package tr.havelsan.ueransim.ngap0.ies.enumerations;

import tr.havelsan.ueransim.ngap0.core.*;

public class NGAP_TimeToWait extends NGAP_Enumerated {

    public static final NGAP_TimeToWait V1S = new NGAP_TimeToWait("v1s");
    public static final NGAP_TimeToWait V2S = new NGAP_TimeToWait("v2s");
    public static final NGAP_TimeToWait V5S = new NGAP_TimeToWait("v5s");
    public static final NGAP_TimeToWait V10S = new NGAP_TimeToWait("v10s");
    public static final NGAP_TimeToWait V20S = new NGAP_TimeToWait("v20s");
    public static final NGAP_TimeToWait V60S = new NGAP_TimeToWait("v60s");

    protected NGAP_TimeToWait(String sValue) {
        super(sValue);
    }

    @Override
    public String getAsnName() {
        return "TimeToWait";
    }

    @Override
    public String getXmlTagName() {
        return "TimeToWait";
    }
}
