/*
 * Copyright (c) 2016 Alenasoft
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software
 * is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.alenasoft.caltrib.dependientes;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by Luis Roberto Perez Rios <luis.robertop87@gmail.com> on 5/11/2016.
 */
public class RCIVAcalcTest extends TestCase {

    private RCIVAdata firstCase;
    private RCIVAdata noTaxesCase;

    public RCIVAcalcTest()
    {
        this.firstCase = new RCIVAdata();
        this.firstCase.totalIncoming = 10275.0;
        this.firstCase.socialSecurityDiscount = 1306.0;
        this.firstCase.bruteIncoming = 8969.0;
        this.firstCase.doubleMinimumSalary = 3610.0;
        this.firstCase.diffToDoubleMinimumSalary = 5359.0;
        this.firstCase.determinedTax = 697.0;
        this.firstCase.doubleMinimumTax = 469.0;
        this.firstCase.taxToBePayed = 228.0;
        this.firstCase.minimumMountToDeclare = 1754.0;

        this.noTaxesCase = new RCIVAdata();
        this.noTaxesCase.totalIncoming = 4000.0;
        this.noTaxesCase.socialSecurityDiscount = 508.0;
        this.noTaxesCase.bruteIncoming = 3492.0;
        this.noTaxesCase.doubleMinimumSalary = 0;
        this.noTaxesCase.diffToDoubleMinimumSalary = 0;
        this.noTaxesCase.determinedTax = 0;
        this.noTaxesCase.doubleMinimumTax = 0;
        this.noTaxesCase.taxToBePayed = 0;
        this.noTaxesCase.minimumMountToDeclare = 0;
    }

    public void testCalculateFirstWellKnownCase() {
        RCIVAcalc testee = new RCIVAcalc();
        double totalIncoming = 10275.0;

        RCIVAdata result = testee.calculate(totalIncoming);

        Assert.assertEquals(this.firstCase, result);
    }

    public void testCalculateNoTaxesCase() {
        RCIVAcalc testee = new RCIVAcalc();
        double totalIncoming = 4000.0;

        RCIVAdata result = testee.calculate(totalIncoming);

        Assert.assertEquals(this.noTaxesCase, result);
    }
}