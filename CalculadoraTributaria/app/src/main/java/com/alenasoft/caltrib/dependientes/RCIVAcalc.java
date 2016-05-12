package com.alenasoft.caltrib.dependientes;

/**
 * Created by roberto on 5/11/2016.
 */
public class RCIVAcalc {

    public final static double SOCIAL_SECURITY_FACTOR = 0.1271;
    public final static double DEFAULT_TAX = 0.13;
    public final static double MINIMUM_SALARY = 1805.00;
    public final static double INVOICES_PAY_FACTOR = 100.0/13.0;

    public static RCIVAdata calculate(double totalIncoming)
    {
        RCIVAdata data = new RCIVAdata();

        data.totalIncoming = totalIncoming;
        data.socialSecurityDiscount = Math.round(data.totalIncoming * RCIVAcalc.SOCIAL_SECURITY_FACTOR);
        data.bruteIncoming = data.totalIncoming - data.socialSecurityDiscount;

        if (data.bruteIncoming > (4 * RCIVAcalc.MINIMUM_SALARY) ) { // RESOLUCION ADMINISTRATIVA N° 05-0040-99, INSTRUCTIVO 1
            data.doubleMinimumSalary = RCIVAcalc.MINIMUM_SALARY * 2;
            data.diffToDoubleMinimumSalary = data.bruteIncoming - data.doubleMinimumSalary;
            data.determinedTax = Math.round(data.diffToDoubleMinimumSalary * RCIVAcalc.DEFAULT_TAX);
            data.doubleMinimumTax = Math.round(data.doubleMinimumSalary * RCIVAcalc.DEFAULT_TAX);
            data.taxToBePayed = data.determinedTax - data.doubleMinimumTax;
            data.minimumMountToDeclare = Math.round(data.taxToBePayed * RCIVAcalc.INVOICES_PAY_FACTOR);
        }

        return data;
    }

}
