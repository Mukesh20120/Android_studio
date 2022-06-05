package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class gamedisplay extends AppCompatActivity {
   private tictaktoeboard tictaktoeboard;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamedisplay);
      Button playagain=findViewById(R.id.playagainbtn);
      Button homebtn=findViewById(R.id.Homebtn);
      TextView playerturn=findViewById(R.id.player_turn);

      playagain.setVisibility(View.GONE);
      homebtn.setVisibility(View.GONE);

      String[] playernames=getIntent().getStringArrayExtra("player_name");

      if(playernames!=null){
          playerturn.setText(playernames[0]+"'s Turn");
      }

     tictaktoeboard=findViewById(R.id.tictaktoeboard);

     tictaktoeboard.setupGame(playagain,homebtn,playerturn,playernames);
    }
    public void playagainbutton(View view){
      tictaktoeboard.resetGame();
      tictaktoeboard.invalidate();
    }

    public void homebutton(View view){
       Intent intent=new Intent(this,MainActivity.class);
       startActivity(intent);
    }
}