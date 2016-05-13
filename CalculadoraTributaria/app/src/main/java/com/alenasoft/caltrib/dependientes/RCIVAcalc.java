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


/**
 * Created by Luis Roberto Perez Rios <luis.robertop87@gmail.com> on 5/11/2016.
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
