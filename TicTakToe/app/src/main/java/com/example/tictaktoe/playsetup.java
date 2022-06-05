package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class playsetup extends AppCompatActivity {

     EditText player1;
     EditText player2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playsetup);
        player1=findViewById(R.id.editTextTextPersonName);
        player2=findViewById(R.id.editTextTextPersonName2);
    }
    public void submitbutton(View view){
        String ply1=player1.getText().toString();
        String ply2=player2.getText().toString();

        Intent intent=new Intent(this,gamedisplay.class);
        intent.putExtra("player_name",new String[]{ply1,ply2});
        startActivity(intent);
    }
}