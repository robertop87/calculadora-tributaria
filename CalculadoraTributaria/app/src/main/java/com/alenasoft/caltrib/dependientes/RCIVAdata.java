
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
 * Created by Luis Roberto Perez Rios <luis.robertop87@gmail.com> on 5/12/2016.
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
