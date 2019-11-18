package com.runsim.backend.nas.impl.values;

import com.runsim.backend.utils.OctetInputStream;
import com.runsim.backend.utils.OctetOutputStream;
import com.runsim.backend.utils.octets.Octet3;
import com.runsim.backend.utils.octets.OctetN;

public class VPartialTrackingAreaIdentityList01 extends VPartialTrackingAreaIdentityList {

    public VMccMnc mccMnc;
    public Octet3 tac;

    public static VPartialTrackingAreaIdentityList01 decode(OctetInputStream stream, int count) {
        var res = new VPartialTrackingAreaIdentityList01();
        res.mccMnc = VMccMnc.decode(stream);
        res.tac = stream.readOctet3();
        return res;
    }

    @Override
    public void encode(OctetOutputStream stream) {
        var flags = new OctetN(0, 1);
        flags = flags.setBitRange(0, 4, 1);
        flags = flags.setBitRange(5, 6, 0b01);
        stream.writeOctets(flags);
        mccMnc.encode(stream);
        stream.writeOctet3(tac);
    }
}
