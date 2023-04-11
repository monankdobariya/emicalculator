package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edtamount, edtrate, edtyear;
    androidx.cardview.widget.CardView cardbuttton;
    TextView txtemi, txtinterest, txttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intview();
    }

    private void intview() {
        edtamount = findViewById(R.id.edtamount);
        edtrate = findViewById(R.id.edtrate);
        edtyear = findViewById(R.id.edtyear);
        cardbuttton = findViewById(R.id.cardbuttton);
        txtemi = findViewById(R.id.txtemi);
        txtinterest = findViewById(R.id.txtinterest);
        txttotal = findViewById(R.id.txttotal);

        cardbuttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer p = Integer.parseInt(edtamount.getText().toString());
                Integer rate = Integer.parseInt(edtrate.getText().toString());
                Integer n = Integer.parseInt(edtyear.getText().toString());

                double r1 = Math.pow(rate+1,n);
                Float interest = Float.valueOf(p * rate * n)/100;

                double monthlyPayment = (double) ((rate+(rate/(r1-1))) * p);
                double totalPayment = monthlyPayment * n;

                txtemi.setText(Float.toString((float) monthlyPayment));
                txtinterest.setText(Float.toString(interest));
                txttotal.setText(Float.toString((float) totalPayment));


            }
        });
    }
}