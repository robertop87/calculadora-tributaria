package com.alenasoft.caltrib.dependientes;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by roberto on 5/11/2016.
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