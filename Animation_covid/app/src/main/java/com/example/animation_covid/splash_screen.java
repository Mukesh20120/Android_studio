package com.example.animation_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Objects;

public class splash_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //how to use splash screen
        //create thread object
        Thread td=new Thread(){
            public void run(){
                try {
                    sleep(5000);
                }
                catch (Exception ex){
                    //mother of all expection
                    ex.printStackTrace();
                }
                finally {
               //if we move on finally then we need to go on our main activity
                    Intent intent=new Intent(splash_screen.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        };td.start();


    }
}