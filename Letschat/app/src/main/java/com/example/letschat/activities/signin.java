package com.example.letschat.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.letschat.R;
import com.example.letschat.databinding.ActivitySigninBinding;

public class signin extends AppCompatActivity {

    private ActivitySigninBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySigninBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setListeners();
    }
    private void setListeners(){
        binding.textCreateNewAccount.setOnClickListener(v->
                startActivity(new Intent(getApplicationContext(),signupActivity.class)));
    }

}