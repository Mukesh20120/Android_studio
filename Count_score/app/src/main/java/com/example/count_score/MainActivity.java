package com.example.count_score;

import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int cnt=0;
    public void addthreepoints(View v){
        cnt+=3;
        Displayscore(cnt);
    }
    public void addtwopoints(View v){
        cnt+=2;
        Displayscore(cnt);
    }
    public void addonepoints(View v){
        cnt+=1;
        Displayscore(cnt);
    }
    public void Displayscore(int n){
        TextView score = findViewById(R.id.team_score);
        score.setText(String.valueOf(n));
    }

    int cntb=0;
    public void addthreepointsb(View v){
        cntb+=3;
        Displayscoreb(cntb);
    }
    public void addtwopointsb(View v){
        cntb+=2;
        Displayscoreb(cntb);
    }
    public void addonepointsb(View v){
        cntb+=1;
        Displayscoreb(cntb);
    }
    public void resetthecntb(View v){
        cntb=0;
        cnt=0;
        Displayscore(cnt);
        Displayscoreb(cntb);
    }
    public void Displayscoreb(int n){
        TextView score = findViewById(R.id.team_scoreb);
        score.setText(String.valueOf(n));
    }
}