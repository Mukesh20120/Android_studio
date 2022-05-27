package com.example.foodplace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Objects;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
         Objects.requireNonNull(getSupportActionBar()).hide();
        Thread thread = new Thread(){
            public void run(){
                try {
                 sleep(4000);
                }
                catch (Exception e){
                e.printStackTrace(); //it is mother of all exception
                }
                finally {
                    Intent intent = new Intent(splash_screen.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };thread.start();

    }
}