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

package tr.havelsan.ueransim.utils.octets;

import tr.havelsan.ueransim.utils.Utils;
import tr.havelsan.ueransim.utils.bits.Bit;

/**
 * Represents 6-octet or 48-bit unsigned integer
 */
public final class Octet6 extends OctetN {

    public Octet6() {
        this(0);
    }

    public Octet6(long value) {
        super(value, 6);
    }

    public Octet6(String hex) {
        this(Utils.toLong(hex));
    }

    @Override
    public final Octet6 setBit(int index, int bit) {
        return new Octet6(super.setBit(index, bit).longValue());
    }

    @Override
    public final Octet6 setBit(int index, Bit bit) {
        return new Octet6(super.setBit(index, bit).longValue());
    }

    @Override
    public final Octet6 setBitRange(int start, int end, long value) {
        return new Octet6(super.setBitRange(start, end, value).longValue());
    }
}
