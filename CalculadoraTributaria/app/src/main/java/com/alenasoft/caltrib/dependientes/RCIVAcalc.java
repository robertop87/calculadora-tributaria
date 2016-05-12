package com.alenasoft.caltrib.dependientes;

/**
 * Created by roberto on 5/11/2016.
 */
public class RCIVAcalc {

    private final double SOCIAL_SECURITY_FACTOR = 0.1271;
    private final double DEFAULT_TAX = 0.13;
    private final double MINIMUN_SALARY = 1805.00;
    private final double INVOICES_PAY_FACTOR = 100.0/13.0;

    private double totalIncoming;
    private double bruteIncoming;
    private double socialSecurityDiscount;
    private double doubleMinimunSalary;
    private double diffWithDoubleMinimunSalary;
    private double determinedTax;
    protected double doubleMinimunTax;
    protected double taxToBePayed;
    protected double minimunMountToDeclare;

    public double getMinimunMountToDeclare() {
        return this.minimunMountToDeclare;
    }

    public double getTotalIncoming() {
        return this.totalIncoming;
    }

    public double getBruteIncoming() {
        return this.bruteIncoming;
    }

    public double getSocialSecurityDiscount() {
        return this.socialSecurityDiscount;
    }

    public double getDoubleMinimunSalary() {
        return this.doubleMinimunSalary;
    }

    public double getDiffWithDoubleMinimunSalary() {
        return this.diffWithDoubleMinimunSalary;
    }

    public double getDeterminedTax() {
        return this.determinedTax;
    }

    public double getDoubleMinimunTax() {
        return this.doubleMinimunTax;
    }

    public double getTaxToBePayed() {
        return this.taxToBePayed;
    }

    public void calculate(double totalIncoming)
    {
        this.totalIncoming = totalIncoming;
        this.socialSecurityDiscount = Math.round(this.totalIncoming * SOCIAL_SECURITY_FACTOR);
        this.bruteIncoming = this.totalIncoming - this.socialSecurityDiscount;
        this.doubleMinimunSalary = MINIMUN_SALARY * 2;
        this.diffWithDoubleMinimunSalary = this.bruteIncoming - this.doubleMinimunSalary;
        this.determinedTax = Math.round(this.diffWithDoubleMinimunSalary * DEFAULT_TAX);
        this.doubleMinimunTax = Math.round(this.doubleMinimunSalary * DEFAULT_TAX);
        this.taxToBePayed = this.determinedTax - this.doubleMinimunTax;
        this.minimunMountToDeclare = Math.round(this.taxToBePayed * INVOICES_PAY_FACTOR);
    }
}

