package com.alenasoft.caltrib.dependientes;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by roberto on 5/11/2016.
 */
public class RCIVAcalcTest extends TestCase {

    private RCIVAdata firstCase;

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
    }

    public void testCalculateFirstWellKnownCase() {
        RCIVAcalc testee = new RCIVAcalc();
        double totalIncoming = 10275.0;

        RCIVAdata result = testee.calculate(totalIncoming);

        Assert.assertEquals(this.firstCase, result);
    }
}