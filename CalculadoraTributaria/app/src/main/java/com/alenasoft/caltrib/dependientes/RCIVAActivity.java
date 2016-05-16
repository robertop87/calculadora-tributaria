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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alenasoft.caltrib.R;

/**
 * Created by Luis Roberto Perez Rios <luis.robertop87@gmail.com> on 5/11/2016.
 */
public class RCIVAActivity extends AppCompatActivity {

    private EditText totalIncomingEditText;
    private TextView bruteIncomingTextView;
    private TextView socialSecurityDiscountTextView;
    private TextView doubleMinimumSalaryTextView;
    private TextView diffToDoubleMinimumSalaryTextView;
    private TextView determinedTaxTextView;
    private TextView doubleMinimumTaxTextView;
    private TextView taxToBePayedTextView;
    private TextView minimumMountToDeclareTextView;

    private TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rciva_dependientes);
        getVisibleComponents();

        totalIncomingEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if ( s.length() > 0 )
                {
                    String incomingText = s.toString();
                    try
                    {
                        double totalIncoming = Double.parseDouble(incomingText);
                        tableLayout.setVisibility(View.VISIBLE);
                        updateForm(RCIVAcalc.calculate(totalIncoming));
                    }
                    catch (NumberFormatException nfe)
                    {
                        tableLayout.setVisibility(View.INVISIBLE);
                        Toast.makeText(RCIVAActivity.this, R.string.invalid_incoming, Toast.LENGTH_SHORT)
                                .show();
                    }
                }
                else
                {
                    tableLayout.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void getVisibleComponents()
    {
        this.tableLayout = (TableLayout)findViewById(R.id.tableLayout_rcivaForm);
        this.tableLayout.setVisibility(View.INVISIBLE);

        this.totalIncomingEditText = (EditText) findViewById(R.id.editText_totalIncoming);

        this.bruteIncomingTextView = (TextView) findViewById(R.id.textView_bruteIncoming);
        this.socialSecurityDiscountTextView = (TextView) findViewById(R.id.textView_socialSecurityDiscount);
        this.doubleMinimumSalaryTextView = (TextView) findViewById(R.id.textView_twoMinimumSalary);
        this.diffToDoubleMinimumSalaryTextView = (TextView) findViewById(R.id.textView_diffToDoubleMinimumSalary);
        this.determinedTaxTextView = (TextView) findViewById(R.id.textView_determinedTax);
        this.doubleMinimumTaxTextView = (TextView) findViewById(R.id.textView_doubleMinimumTax);
        this.taxToBePayedTextView = (TextView) findViewById(R.id.textView_taxToBePayed);
        this.minimumMountToDeclareTextView = (TextView) findViewById(R.id.textView_minimumMountToDeclare);
    }

    private void updateForm(RCIVAdata data)
    {
        this.setDoubleInTextView(this.bruteIncomingTextView, data.bruteIncoming);
        this.setDoubleInTextView(this.socialSecurityDiscountTextView, data.socialSecurityDiscount);
        this.setDoubleInTextView(this.doubleMinimumSalaryTextView, data.doubleMinimumSalary);
        this.setDoubleInTextView(this.diffToDoubleMinimumSalaryTextView, data.diffToDoubleMinimumSalary);
        this.setDoubleInTextView(this.determinedTaxTextView, data.determinedTax);
        this.setDoubleInTextView(this.doubleMinimumTaxTextView, data.doubleMinimumTax);
        this.setDoubleInTextView(this.taxToBePayedTextView, data.taxToBePayed);
        this.setDoubleInTextView(this.minimumMountToDeclareTextView, data.minimumMountToDeclare);
    }

    private void setDoubleInTextView(TextView textView, double value) {
        textView.setText( String.format("%.0f", value ) );
    }
}
