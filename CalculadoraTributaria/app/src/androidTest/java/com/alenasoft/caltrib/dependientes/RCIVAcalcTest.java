package com.alenasoft.caltrib.dependientes;

import junit.framework.Assert;
import junit.framework.TestCase;

/**
 * Created by roberto on 5/11/2016.
 */
public class RCIVAcalcTest extends TestCase {

    public void testCalculate() {
        RCIVAcalc testee = new RCIVAcalc();
        double totalIncoming = 10275.0;

        testee.calculate(totalIncoming);

        Assert.assertEquals(1306.0, testee.getSocialSecurityDiscount());
        Assert.assertEquals(8969.0, testee.getBruteIncoming());
        Assert.assertEquals(3610.0, testee.getDoubleMinimunSalary());
        Assert.assertEquals(5359.0, testee.getDiffWithDoubleMinimunSalary());
        Assert.assertEquals(697.0, testee.getDeterminedTax());
        Assert.assertEquals(469.0, testee.getDoubleMinimunTax());
        Assert.assertEquals(228.0, testee.taxToBePayed);
        Assert.assertEquals(1754.0, testee.getMinimunMountToDeclare());
    }
}