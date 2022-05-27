package com.example.calculator1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.calculator1.R;

public class MainActivity extends AppCompatActivity {
    //we are defining variable global declare
    EditText etFirstValue,etSecondValue;
    TextView tvAns;
    Button add,sub,mul,div;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //now initilized the variable
        etFirstValue=findViewById(R.id.etFirstValue);
        etSecondValue=findViewById(R.id.etSecondValue);

        tvAns=findViewById(R.id.tvAns);

        add=findViewById(R.id.btnAdd);
        sub=findViewById(R.id.btnSubtract);
        mul=findViewById(R.id.btnMultiply);
        div=findViewById(R.id.btnDivide);

        add.setOnClickListener(view -> {
            int firstvalue,secondValues,ans;
            firstvalue=Integer.parseInt(etFirstValue.getText().toString());
            secondValues=Integer.parseInt(etSecondValue.getText().toString());

            ans=firstvalue+secondValues;

            tvAns.setText("Answer is = "+ ans);
        });

        sub.setOnClickListener(view -> {
            int firstvalue,secondValues,ans;
            firstvalue=Integer.parseInt(etFirstValue.getText().toString());
            secondValues=Integer.parseInt(etSecondValue.getText().toString());

            ans=firstvalue-secondValues;

            tvAns.setText("Answer is = "+ ans);
        });
        mul.setOnClickListener(view -> {
            int firstvalue,secondValues,ans;
            firstvalue=Integer.parseInt(etFirstValue.getText().toString());
            secondValues=Integer.parseInt(etSecondValue.getText().toString());

            ans=firstvalue*secondValues;

            tvAns.setText("Answer is = "+ ans);
        });
        div.setOnClickListener(view -> {
            int firstvalue,secondValues,ans;
            firstvalue=Integer.parseInt(etFirstValue.getText().toString());
            secondValues=Integer.parseInt(etSecondValue.getText().toString());

            ans=firstvalue/secondValues;

            tvAns.setText("Answer is = "+ ans);
        });
    }
}