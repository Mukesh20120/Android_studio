package com.example.foodplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class login extends AppCompatActivity {
    TextView want_to_reg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sign In");
        want_to_reg=findViewById(R.id.w_t_r);
        want_to_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(login.this, "Register Here", Toast.LENGTH_SHORT).show();
                Intent in=new Intent(login.this,sign_up.class);
                startActivity(in);
            }
        });
    }
}