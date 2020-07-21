package tr.havelsan.ueransim.ngap0.msg;

import tr.havelsan.ueransim.ngap0.core.*;
import tr.havelsan.ueransim.ngap0.NgapMessageType;
import tr.havelsan.ueransim.ngap0.ies.choices.*;

public class NGAP_NGReset extends NGAP_BaseMessage {

    public NGAP_NGReset() {

    }

    @Override
    public NgapMessageType getMessageType() {
        return NgapMessageType.NGReset;
    }

    @Override
    public int getCriticality() {
        return 0;
    }

    @Override
    public int getProcedureCode() {
        return 20;
    }

    @Override
    public int getPduType() {
        return 0;
    }

    @Override
    public int[] getIeId() {
        return new int[]{15, 88};
    }

    @Override
    public int[] getIeCriticality() {
        return new int[]{1, 0};
    }

    @Override
    public Class<? extends NGAP_Value>[] getIeTypes() {
        return new Class[]{NGAP_Cause.class, NGAP_ResetType.class};
    }

    @Override
    public int[] getIePresence() {
        return new int[]{2, 2};
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
        return "NGReset";
    }

    @Override
    public String getXmlTagName() {
        return "NGReset";
    }

}
