package com.alenasoft.caltrib.dependientes;

/**
 * Created by roberto on 5/11/2016.
 */
public class RCIVAcalc {

    private final double SOCIAL_SECURITY_FACTOR = 0.1271;
    private final double DEFAULT_TAX = 0.13;
    private final double MINIMUN_SALARY = 1805.00;
    private final double INVOICES_PAY_FACTOR = 100.0/13.0;

    public RCIVAdata calculate(double totalIncoming)
    {
        RCIVAdata data = new RCIVAdata();

        data.totalIncoming = totalIncoming;
        data.socialSecurityDiscount = Math.round(data.totalIncoming * SOCIAL_SECURITY_FACTOR);
        data.bruteIncoming = data.totalIncoming - data.socialSecurityDiscount;
        data.doubleMinimumSalary = MINIMUN_SALARY * 2;
        data.diffToDoubleMinimumSalary = data.bruteIncoming - data.doubleMinimumSalary;
        data.determinedTax = Math.round(data.diffToDoubleMinimumSalary * DEFAULT_TAX);
        data.doubleMinimumTax = Math.round(data.doubleMinimumSalary * DEFAULT_TAX);
        data.taxToBePayed = data.determinedTax - data.doubleMinimumTax;
        data.minimumMountToDeclare = Math.round(data.taxToBePayed * INVOICES_PAY_FACTOR);

        return data;
    }

}
