package com.example.animation_covid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
   LottieAnimationView lottieAnimationView;
   Button testcovid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        lottieAnimationView=findViewById(R.id.animation1);
        testcovid=findViewById(R.id.testbtn);

        testcovid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lottieAnimationView.setVisibility(View.VISIBLE);
                testcovid.setVisibility(View.INVISIBLE);
                lottieAnimationView.playAnimation();
                //now we need some thing like splash screen and it move to
                //another details page of our android
                Thread td=new Thread(){
                    public void run(){
                        try {
                            sleep(4000);
                        }
                        catch (Exception ex){
                            //mother of all expection
                            ex.printStackTrace();
                        }
                        finally {
                            //if we move on finally then we need to go on our main activity
                            Intent intent=new Intent(MainActivity.this,deatils.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                };td.start();
            }
        });

    }
}