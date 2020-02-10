package tr.havelsan.ueransim.flows;

import fr.marben.asnsdk.japi.InvalidStructureException;
import fr.marben.asnsdk.japi.spe.OpenTypeValue;
import threegpp.milenage.Milenage;
import threegpp.milenage.MilenageBufferFactory;
import threegpp.milenage.MilenageResult;
import threegpp.milenage.biginteger.BigIntegerBuffer;
import threegpp.milenage.biginteger.BigIntegerBufferFactory;
import threegpp.milenage.cipher.Ciphers;
import tr.havelsan.ueransim.BaseFlow;
import tr.havelsan.ueransim.Message;
import tr.havelsan.ueransim.Ngap;
import tr.havelsan.ueransim.app.Json;
import tr.havelsan.ueransim.app.ue.UeUtils;
import tr.havelsan.ueransim.inputs.RegistrationInput;
import tr.havelsan.ueransim.nas.core.messages.NasMessage;
import tr.havelsan.ueransim.nas.core.messages.PlainMmMessage;
import tr.havelsan.ueransim.nas.eap.Eap;
import tr.havelsan.ueransim.nas.eap.EapAkaPrime;
import tr.havelsan.ueransim.nas.impl.enums.EIdentityType;
import tr.havelsan.ueransim.nas.impl.ies.*;
import tr.havelsan.ueransim.nas.impl.messages.*;
import tr.havelsan.ueransim.ngap.Values;
import tr.havelsan.ueransim.ngap.ngap_commondatatypes.Criticality;
import tr.havelsan.ueransim.ngap.ngap_commondatatypes.ProcedureCode;
import tr.havelsan.ueransim.ngap.ngap_commondatatypes.ProtocolIE_ID;
import tr.havelsan.ueransim.ngap.ngap_ies.AMF_UE_NGAP_ID;
import tr.havelsan.ueransim.ngap.ngap_ies.RAN_UE_NGAP_ID;
import tr.havelsan.ueransim.ngap.ngap_pdu_contents.DownlinkNASTransport;
import tr.havelsan.ueransim.ngap.ngap_pdu_contents.ErrorIndication;
import tr.havelsan.ueransim.ngap.ngap_pdu_contents.InitialContextSetupRequest;
import tr.havelsan.ueransim.ngap.ngap_pdu_contents.InitialContextSetupResponse;
import tr.havelsan.ueransim.ngap.ngap_pdu_descriptions.InitiatingMessage;
import tr.havelsan.ueransim.ngap.ngap_pdu_descriptions.NGAP_PDU;
import tr.havelsan.ueransim.ngap.ngap_pdu_descriptions.SuccessfulOutcome;
import tr.havelsan.ueransim.sctp.SCTPClient;
import tr.havelsan.ueransim.utils.Color;
import tr.havelsan.ueransim.utils.Console;
import tr.havelsan.ueransim.utils.Utils;
import tr.havelsan.ueransim.utils.octets.Octet;
import tr.havelsan.ueransim.utils.octets.OctetString;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegistrationFlow extends BaseFlow {

    private final RegistrationInput input;
    private final MilenageBufferFactory<BigIntegerBuffer> milenageBufferFactory;
    private long amfUeNgapId;

    public RegistrationFlow(SCTPClient sctpClient, RegistrationInput input) {
        super(sctpClient);
        this.input = input;
        this.milenageBufferFactory = BigIntegerBufferFactory.getInstance();
    }

    @Override
    public State main(Message message) {
        return sendRegistrationRequest();
    }

    private State sendRegistrationRequest() {
        var registrationRequest = new RegistrationRequest();
        registrationRequest.registrationType =
                new IE5gsRegistrationType(
                        IE5gsRegistrationType.EFollowOnRequest.NO_FOR_PENDING,
                        IE5gsRegistrationType.ERegistrationType.INITIAL_REGISTRATION);
        registrationRequest.nasKeySetIdentifier =
                new IENasKeySetIdentifier(
                        IENasKeySetIdentifier.ETypeOfSecurityContext.NATIVE_SECURITY_CONTEXT, input.ngKSI);
        registrationRequest.requestedNSSAI = new IENssai(input.requestNssai);
        registrationRequest.mobileIdentity = input.mobileIdentity;

        sendInitialUeMessage(registrationRequest);
        return this::waitAmfMessages;
    }

    private State waitAmfMessages(Message message) {
        var pdu = message.getAsPDU();
        logReceivedMessage(pdu);

        if (!(pdu.getValue() instanceof InitiatingMessage)) {
            Console.println(Color.YELLOW, "bad message, InitiatingMessage is expected. message ignored");
            return this::waitAmfMessages;
        }

        var initiatingMessage = ((InitiatingMessage) pdu.getValue()).value.getDecodedValue();

        if (initiatingMessage instanceof DownlinkNASTransport) {
            var downlinkNASTransport = (DownlinkNASTransport) initiatingMessage;
            for (var item : downlinkNASTransport.protocolIEs.valueList) {
                var protocolIE = (DownlinkNASTransport.ProtocolIEs.SEQUENCE) item;
                if (protocolIE.value.getDecodedValue() instanceof AMF_UE_NGAP_ID) {
                    var amfUeNgapId = (AMF_UE_NGAP_ID) protocolIE.value.getDecodedValue();
                    this.amfUeNgapId = amfUeNgapId.value;
                }
            }
            return handleDownlinkNASTransport(downlinkNASTransport);
        } else if (initiatingMessage instanceof InitialContextSetupRequest) {
            return handleInitialContextSetup();
        } else if (initiatingMessage instanceof ErrorIndication) {
            Console.println(Color.RED, "Error indication received, message ignored");
            return this::waitAmfMessages;
        } else {
            Console.println(Color.YELLOW, "unhandled ngap message. message ignored");
            return this::waitAmfMessages;
        }
    }

    private State handleDownlinkNASTransport(DownlinkNASTransport message) {
        var nasMessage = UeUtils.getNasMessage(message);
        if (nasMessage == null) {
            Console.printDiv();
            Console.println(Color.RED, "bad message, NAS PDU was expected.");
            Console.println(Color.RED, "closing connection");
            return closeConnection();
        }
        return handleNasMessage(nasMessage);
    }

    private State handleNasMessage(NasMessage nasMessage) {
        Console.println(Color.BLUE, "Received NAS message is:");
        Console.println(Color.WHITE_BRIGHT, Json.toJson(nasMessage));
        Console.printDiv();
        Console.println(Color.BLUE, "NAS message is handling.");

        if (!(nasMessage instanceof PlainMmMessage)) {
            Console.println(Color.RED, "Security protected NAS messages are not implemented yet");
            Console.println(Color.RED, "Closing connection");
            return closeConnection();
        }

        var message = (PlainMmMessage) nasMessage;

        Console.println(Color.BLUE, message.messageType.name(), "is detected");

        if (message instanceof AuthenticationRequest) {
            return handleAuthenticationRequest((AuthenticationRequest) message);
        } else if (message instanceof AuthenticationResult) {
            return handleAuthenticationResult((AuthenticationResult) message);
        } else if (message instanceof RegistrationReject) {
            return handleRegistrationReject((RegistrationReject) message);
        } else if (message instanceof IdentityRequest) {
            return handleIdentityRequest((IdentityRequest) message);
        } else if (message instanceof RegistrationAccept) {
            return handleRegistrationAccept((RegistrationAccept) message);
        } else {
            Console.println(
                    Color.YELLOW,
                    "This message type was not implemented yet: %s",
                    message.getClass().getSimpleName());
            Console.println(Color.YELLOW, "Ignoring message");
            return this::waitAmfMessages;
        }
    }

    private State handleInitialContextSetup() {
        var list = new ArrayList<InitialContextSetupResponse.ProtocolIEs.SEQUENCE>();

        var contextSetupResponse = new InitialContextSetupResponse();
        contextSetupResponse.protocolIEs = new InitialContextSetupResponse.ProtocolIEs();
        contextSetupResponse.protocolIEs.valueList = list;

        var item0 = new InitialContextSetupResponse.ProtocolIEs.SEQUENCE();
        item0.id = new ProtocolIE_ID(Values.NGAP_Constants__id_RAN_UE_NGAP_ID);
        item0.criticality = new Criticality(Criticality.ASN_ignore);
        item0.value = new OpenTypeValue(new RAN_UE_NGAP_ID(input.ranUeNgapId));

        var item1 = new InitialContextSetupResponse.ProtocolIEs.SEQUENCE();
        item1.id = new ProtocolIE_ID(Values.NGAP_Constants__id_AMF_UE_NGAP_ID);
        item1.criticality = new Criticality(Criticality.ASN_ignore);
        item1.value = new OpenTypeValue(new AMF_UE_NGAP_ID(amfUeNgapId));

        list.add(item0);
        list.add(item1);

        NGAP_PDU ngapPdu;
        try {
            var successfulOutcome = new SuccessfulOutcome();
            successfulOutcome.procedureCode =
                    new ProcedureCode(Values.NGAP_Constants__id_InitialContextSetup);
            successfulOutcome.criticality = new Criticality(Criticality.ASN_reject);
            successfulOutcome.value = new OpenTypeValue(contextSetupResponse);

            ngapPdu = new NGAP_PDU(NGAP_PDU.ASN_successfulOutcome, successfulOutcome);
        } catch (InvalidStructureException e) {
            throw new RuntimeException(e);
        }

        sendNgapMessage(ngapPdu);

        var response = new RegistrationComplete();
        sendUplinkMessage(response);

        Console.println(Color.GREEN_BOLD, "Registration successfully completed.");
        return abortReceiver();
    }

    private State handleRegistrationReject(RegistrationReject message) {
        Console.println(Color.RED, "RegistrationReject result received.");
        return closeConnection();
    }

    private State handleAuthenticationResult(AuthenticationResult message) {
        Console.println(Color.BLUE, "Authentication result received");
        return this::waitAmfMessages;
    }

    private State handleRegistrationAccept(RegistrationAccept message) {
        var response = new RegistrationComplete();
        sendUplinkMessage(response);

        Console.println(Color.GREEN_BOLD, "Registration successfully completed.");
        return abortReceiver();
    }

    private State handleAuthenticationRequest(AuthenticationRequest message) {
        Console.printDiv();
        Console.println(Color.BLUE, "AuthenticationRequest is handling.");

        OctetString mac;
        byte[] res;
        Octet id;

        // Handle request
        {
            var akaPrime = (EapAkaPrime) message.eapMessage.eap;
            var rand = akaPrime.attributes.get(EapAkaPrime.EAttributeType.AT_RAND);
            rand = rand.substring(2); // warning

            mac = akaPrime.attributes.get(EapAkaPrime.EAttributeType.AT_MAC);
            id = akaPrime.id;

            final String OP = input.eapAkaInput.OP;
            final String SQN = input.eapAkaInput.SQN;
            final String AMF = input.eapAkaInput.AMF;
            final String KEY = input.eapAkaInput.KEY;

            byte[] op = Utils.hexStringToByteArray(OP);
            byte[] sqn = Utils.hexStringToByteArray(SQN);
            byte[] amf = Utils.hexStringToByteArray(AMF);

            var cipher = Ciphers.createRijndaelCipher(Utils.hexStringToByteArray(KEY));

            byte[] opc = Milenage.calculateOPc(op, cipher, milenageBufferFactory);

            Milenage<BigIntegerBuffer> milenage = new Milenage<>(opc, cipher, milenageBufferFactory);
            ExecutorService executorService = Executors.newCachedThreadPool();

            Map<MilenageResult, byte[]> result;
            try {
                result = milenage.calculateAll(rand.substring(0).toByteArray(), sqn, amf, executorService);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            executorService.shutdown();
            res = result.get(MilenageResult.RES);

            int padding = (res.length + 2) % 4;
            byte[] paddedRes = new byte[res.length + padding];
            if (padding >= 0) System.arraycopy(res, 0, paddedRes, padding, res.length);
            res = paddedRes;
        }

        // Send response
        {
            var response = new AuthenticationResponse();
            response.authenticationResponseParameter =
                    new IEAuthenticationResponseParameter(input.authenticationResponseParameter);

            var akaPrime = new EapAkaPrime(Eap.ECode.RESPONSE, id);
            akaPrime.subType = EapAkaPrime.ESubType.AKA_CHALLENGE;
            akaPrime.attributes = new LinkedHashMap<>();
            akaPrime.attributes.put(EapAkaPrime.EAttributeType.AT_RES, new OctetString(res));
            akaPrime.attributes.put(EapAkaPrime.EAttributeType.AT_MAC, mac);
            response.eapMessage = new IEEapMessage(akaPrime);

            sendUplinkMessage(response);
        }

        return this::waitAmfMessages;
    }

    private State handleIdentityRequest(IdentityRequest message) {
        if (!message.identityType.value.equals(EIdentityType.IMEI)) {
            Console.println(
                    Color.RED,
                    "Identity request for %s is not implemented yet",
                    message.identityType.value.name());
            return this::waitAmfMessages;
        }

        var response = new IdentityResponse();
        response.mobileIdentity = new IEImeiMobileIdentity(input.imei);
        sendUplinkMessage(response);

        return this::waitAmfMessages;
    }

    private void sendInitialUeMessage(NasMessage nas) {
        logNasMessageWillSend(nas);
        var ngapPdu = UeUtils.createInitialUeMessage(
                nas, input.ranUeNgapId, input.rrcEstablishmentCause, input.userLocationInformationNr);
        sendNgapMessage(ngapPdu);
    }

    private void sendUplinkMessage(NasMessage nas) {
        logNasMessageWillSend(nas);
        var ngapPdu = UeUtils.createUplinkMessage(nas, input.ranUeNgapId, amfUeNgapId, input.userLocationInformationNr);
        sendNgapMessage(ngapPdu);
    }

    public void logNasMessageWillSend(NasMessage nasMessage) {
        Console.printDiv();
        Console.println(Color.BLUE, nasMessage.getClass().getSimpleName() + " will be sent");
        Console.println(Color.BLUE, "While NAS message is:");
        Console.println(Color.WHITE_BRIGHT, Json.toJson(nasMessage));
    }

    public void sendNgapMessage(NGAP_PDU ngapPdu) {
        Console.printDiv();
        Console.println(Color.BLUE, "Following NGAP message will be sent:");
        Console.println(Color.WHITE_BRIGHT, Utils.xmlToJson(Ngap.xerEncode(ngapPdu)));

        sendPDU(ngapPdu);

        Console.println(Color.BLUE, "Message sent");
    }

    public void logReceivedMessage(NGAP_PDU ngapPdu) {
        Console.printDiv();
        Console.println(Color.BLUE, "Received NGAP PDU:");
        Console.println(Color.WHITE_BRIGHT, Utils.xmlToJson(Ngap.xerEncode(ngapPdu)));
    }
}
