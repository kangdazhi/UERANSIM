package com.runsim.backend.nas.impl.enums;

import com.runsim.backend.nas.core.ProtocolEnum;

public class ESscMode extends ProtocolEnum {
    public static final ESscMode SSC_MODE_1
            = new ESscMode(0b001, "SSC mode 1");
    public static final ESscMode SSC_MODE_2
            = new ESscMode(0b010, "SSC mode 2");
    public static final ESscMode SSC_MODE_3
            = new ESscMode(0b011, "SSC mode 3");
    public static final ESscMode UNUSED_1
            = new ESscMode(0b100, "unused; shall be interpreted as \"SSC mode 1\", if received by the network");
    public static final ESscMode UNUSED_2
            = new ESscMode(0b101, "unused; shall be interpreted as \"SSC mode 2\", if received by the network");
    public static final ESscMode UNUSED_3
            = new ESscMode(0b110, "unused; shall be interpreted as \"SSC mode 3\", if received by the network");

    private ESscMode(int value, String name) {
        super(value, name);
    }

    public static ESscMode fromValue(int value) {
        var val = fromValueGeneric(ESscMode.class, value);
        if (val.equals(UNUSED_1)) return SSC_MODE_1;
        if (val.equals(UNUSED_2)) return SSC_MODE_2;
        if (val.equals(UNUSED_3)) return SSC_MODE_3;
        return val;
    }
}
