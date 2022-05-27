package com.example.foodplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class sign_up extends AppCompatActivity {
    TextView alreadyacc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Register");

        alreadyacc=findViewById(R.id.alreadyhaveaccount);
        alreadyacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(sign_up.this, "Already have account", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(sign_up.this,login.class);
                startActivity(intent);
            }
        });
    }
}