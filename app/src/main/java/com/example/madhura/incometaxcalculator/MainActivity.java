package com.example.madhura.incometaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.madhura.incometaxcalculator.R;

public class MainActivity extends AppCompatActivity {

    EditText grossIncome, mediclaim, policy_ded, home_loan, home_loan_interest, education_loan;
    int gross, medi, poli_ded, h_loan, h_loan_int, edu_loan;
    Button calculate;
    TextView taxable_income_tv, tax_calculated_tv, VAT_tv, final_calcuated_tv;
    float tax_calculated = 0, VAT, final_calculated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculate = (Button)findViewById(R.id.calculate);
        grossIncome = (EditText)findViewById(R.id.gross_income);
        mediclaim = (EditText)findViewById(R.id.mediclaim);
        policy_ded = (EditText)findViewById(R.id.policy_deduction);
        home_loan = (EditText)findViewById(R.id.home_loan);
        home_loan_interest = (EditText)findViewById(R.id.home_loan_interest);
        education_loan = (EditText)findViewById(R.id.education_loan);

        taxable_income_tv = (TextView)findViewById(R.id.taxable_income);
        tax_calculated_tv = (TextView)findViewById(R.id.tax_calculated);
        VAT_tv = (TextView)findViewById(R.id.VAT);
        final_calcuated_tv = (TextView)findViewById(R.id.final_income_tax);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                gross = Integer.parseInt(grossIncome.getText().toString());
                medi = Integer.parseInt(mediclaim.getText().toString());
                poli_ded = Integer.parseInt(policy_ded.getText().toString());
                h_loan = Integer.parseInt(home_loan.getText().toString());
                h_loan_int = Integer.parseInt(home_loan_interest.getText().toString());
                edu_loan = Integer.parseInt(education_loan.getText().toString());

                if(medi <= 50000) {
                    gross = gross - medi;
                }
                else {
                    gross = gross - 50000;
                }

                if(poli_ded <= 100000) {
                    gross = gross - poli_ded;
                }
                else {
                    gross = gross - 100000;
                }

                if(h_loan <= 300000) {
                    gross = gross - h_loan;
                }
                else {
                    gross = gross - 300000;
                }

                if(h_loan_int <= 150000) {
                    gross = gross - h_loan_int;
                }
                else {
                    gross = gross - 150000;
                }

                if(edu_loan <= 50000) {
                    gross = gross - edu_loan;
                }
                else {
                    gross = gross - 50000;
                }

                taxable_income_tv.setText(String.valueOf(gross));

                if(gross > 1000000) {
                    tax_calculated = (float) (tax_calculated + (0.35)*(gross-1000000));
                    tax_calculated+=150000;

                }
                else if(gross > 750000) {
                    tax_calculated = (float) (tax_calculated + (0.3)*(gross-750000));
                    tax_calculated+=75000;
                }
                else if(gross>500000)
                {
                    tax_calculated = (float) (tax_calculated + (0.2)*(gross-500000));
                    tax_calculated+=25000;
                }
                else if(gross>250000)
                {
                    tax_calculated = (float) (tax_calculated + (0.1)*(gross-250000));

                }
                else tax_calculated=0;

                tax_calculated_tv.setText(String.valueOf(tax_calculated));

                VAT = (float) (tax_calculated * (0.03));

                VAT_tv.setText(String.valueOf(VAT));

                final_calculated = VAT + tax_calculated;
                final_calcuated_tv.setText(String.valueOf(final_calculated));
            }
        });


    }
}
