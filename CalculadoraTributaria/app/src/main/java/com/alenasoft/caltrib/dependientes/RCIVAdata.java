package com.alenasoft.caltrib.dependientes;

/**
 * Created by roberto on 5/12/2016.
 */
public class RCIVAdata {

    public double totalIncoming;
    public double bruteIncoming;
    public double socialSecurityDiscount;
    public double doubleMinimumSalary;
    public double diffToDoubleMinimumSalary;
    public double determinedTax;
    public double doubleMinimumTax;
    public double taxToBePayed;
    public double minimumMountToDeclare;

    @Override
    public boolean equals(Object object)
    {
        RCIVAdata data = (RCIVAdata) object;

        return  this.totalIncoming == data.totalIncoming
                && this.bruteIncoming == data.bruteIncoming
                && this.socialSecurityDiscount == data.socialSecurityDiscount
                && this.doubleMinimumSalary == data.doubleMinimumSalary
                && this.diffToDoubleMinimumSalary == data.diffToDoubleMinimumSalary
                && this.determinedTax == data.determinedTax
                && this.doubleMinimumTax == data.doubleMinimumTax
                && this.taxToBePayed == data.taxToBePayed
                && this.minimumMountToDeclare == data.minimumMountToDeclare;
    }
}
