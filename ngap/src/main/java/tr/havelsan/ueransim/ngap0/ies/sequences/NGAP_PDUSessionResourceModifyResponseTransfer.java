/*
 * MIT License
 *
 * Copyright (c) 2020 ALİ GÜNGÖR
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package tr.havelsan.ueransim.ngap0.ies.sequences;

import tr.havelsan.ueransim.ngap0.core.*;
import tr.havelsan.ueransim.ngap0.pdu.*;
import tr.havelsan.ueransim.utils.bits.*;
import tr.havelsan.ueransim.utils.octets.*;
import tr.havelsan.ueransim.ngap0.ies.bit_strings.*;
import tr.havelsan.ueransim.ngap0.ies.octet_strings.*;
import tr.havelsan.ueransim.ngap0.ies.printable_strings.*;
import tr.havelsan.ueransim.ngap0.ies.sequences.*;
import tr.havelsan.ueransim.ngap0.ies.sequence_ofs.*;
import tr.havelsan.ueransim.ngap0.ies.choices.*;
import tr.havelsan.ueransim.ngap0.ies.integers.*;
import tr.havelsan.ueransim.ngap0.ies.enumerations.*;

import java.util.List;

public class NGAP_PDUSessionResourceModifyResponseTransfer extends NGAP_Sequence {

    public NGAP_UPTransportLayerInformation dL_NGU_UP_TNLInformation;
    public NGAP_UPTransportLayerInformation uL_NGU_UP_TNLInformation;
    public NGAP_QosFlowAddOrModifyResponseList qosFlowAddOrModifyResponseList;
    public NGAP_QosFlowPerTNLInformation additionalQosFlowPerTNLInformation;
    public NGAP_QosFlowList qosFlowFailedToAddOrModifyList;

    @Override
    public String getAsnName() {
        return "PDUSessionResourceModifyResponseTransfer";
    }

    @Override
    public String getXmlTagName() {
        return "PDUSessionResourceModifyResponseTransfer";
    }

    @Override
    public String[] getMemberNames() {
        return new String[]{"dL-NGU-UP-TNLInformation", "uL-NGU-UP-TNLInformation", "qosFlowAddOrModifyResponseList", "additionalQosFlowPerTNLInformation", "qosFlowFailedToAddOrModifyList"};
    }

    @Override
    public String[] getMemberIdentifiers() {
        return new String[]{"dL_NGU_UP_TNLInformation", "uL_NGU_UP_TNLInformation", "qosFlowAddOrModifyResponseList", "additionalQosFlowPerTNLInformation", "qosFlowFailedToAddOrModifyList"};
    }
}
