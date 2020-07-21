package tr.havelsan.ueransim.ngap0.msg;

import tr.havelsan.ueransim.ngap0.core.*;
import tr.havelsan.ueransim.ngap0.NgapMessageType;
import tr.havelsan.ueransim.ngap0.ies.sequences.*;
import tr.havelsan.ueransim.ngap0.ies.choices.*;
import tr.havelsan.ueransim.ngap0.ies.integers.*;

public class NGAP_HandoverFailure extends NGAP_BaseMessage {

    public NGAP_HandoverFailure() {

    }

    @Override
    public NgapMessageType getMessageType() {
        return NgapMessageType.HandoverFailure;
    }

    @Override
    public int getCriticality() {
        return 0;
    }

    @Override
    public int getProcedureCode() {
        return 13;
    }

    @Override
    public int getPduType() {
        return 2;
    }

    @Override
    public int[] getIeId() {
        return new int[]{10, 15, 19};
    }

    @Override
    public int[] getIeCriticality() {
        return new int[]{1, 1, 1};
    }

    @Override
    public Class<? extends NGAP_Value>[] getIeTypes() {
        return new Class[]{NGAP_AMF_UE_NGAP_ID.class, NGAP_Cause.class, NGAP_CriticalityDiagnostics.class};
    }

    @Override
    public int[] getIePresence() {
        return new int[]{2, 2, 0};
    }

    @Override
    public String[] getMemberIdentifiers() {
        return new String[]{"protocolIEs"};
    }

    @Override
    public String[] getMemberNames() {
        return new String[]{"protocolIEs"};
    }

    @Override
    public String getAsnName() {
        return "HandoverFailure";
    }

    @Override
    public String getXmlTagName() {
        return "HandoverFailure";
    }

}
