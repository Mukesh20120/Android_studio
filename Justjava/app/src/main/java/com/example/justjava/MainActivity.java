package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quan=0;
    public int quantity(int n){
        return n*5;
    }
    @SuppressLint("QueryPermissionsNeeded")
    public void submitOrder(View view)
    {
        //creating check box variable and store the checkbox of wipping cream
        CheckBox wipp= findViewById(R.id.wrapping);
        //create a bool variable and store the value of our checkbox variable
        boolean w=wipp.isChecked();


        //similar for the chocolate
        CheckBox choco=findViewById(R.id.chocolate);
        boolean cho=choco.isChecked();

        //extracting text from the input
        EditText name= findViewById(R.id.customer);
        String cust=name.getText().toString();


       int price=quantity(quan);

       String dismsg=createordersummary(cust,price,w,cho);
        displayprice(dismsg);
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, dismsg);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
    private String createordersummary(String cut,int p,boolean w,boolean c){
        String msg ="Name: "+ cut;
        msg+="\n Adding wipped cream ?" + w;
        msg+="\n Adding chocolate ?" + c;
        msg+="\nQuantity = " + quan;
        msg+="\nTotal price = " + p;
        msg+="\nThankyou !";

        return msg;
    }

    public void increseit(View view){
        quan=quan+1;
        display(quan);
    }
    public void decreaseit(View view){
        quan=quan-1;
        display(quan);
    }

    @SuppressLint("SetTextI18n")
    private void display(int number){
        TextView quantityTextView =  findViewById(R.id.quantity_text_view);
     quantityTextView.setText("" + number);
    }
    private void displayprice(String n){
        TextView quantityTextView =  findViewById(R.id.total_price);
        quantityTextView.setText(n);
    }
}