package com.example.tictaktoe;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

class GameLogic {
    private  int[][]gameboard;

    private int[] winType={-1,-1,-1};
    private String[] playername={"player1","player2"};

    private Button playerbtn;
    private Button homebtn;
    private TextView playerTurn;

    private int player=1;
    GameLogic() {
        gameboard = new int[3][3];
        //now initilized all the value with 0
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameboard[r][c] = 0;
            }
        }
    }

    @SuppressLint("SetTextI18n")
    public boolean updateGameBoard(int row, int col){
        if(gameboard[row-1][col-1]==0){
            gameboard[row-1][col-1]=player;

          if(player==1){
              playerTurn.setText((playername[1]+"'s Turn"));
          }
          else{
              playerTurn.setText((playername[0]+"'s Turn"));
          }
            return true;
        }
        else{
            return false;
        }
    }
    @SuppressLint("SetTextI18n")
    public void resetGame(){
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                gameboard[r][c] = 0;
            }
        }
        //we need  to initilized our variable back to normal
        player=1;
        playerbtn.setVisibility(View.GONE);
        homebtn.setVisibility(View.GONE);
        playerTurn.setText(playername[0]+"'s Turn");
    }
    public int[][] getGameboard() {
        return gameboard;
    }

    public void setPlayer(int player) {
        this.player = player;
    }

    public int getPlayer() {
        return player;
    }

    public void setPlayerbtn(Button playerbtn) {
        this.playerbtn = playerbtn;
    }

    public void setHomebtn(Button homebtn) {
        this.homebtn = homebtn;
    }

    public void setPlayerTurn(TextView playerTurn) {
        this.playerTurn = playerTurn;
    }

    public void setPlayername(String[] playername) {
        this.playername = playername;
    }

    @SuppressLint("SetTextI18n")
    public boolean winnerCheck(){
        //horizontal check
        boolean iswinner=false;
        for(int r=0;r<3;r++){
            if (gameboard[r][0] == gameboard[r][1] && gameboard[r][0] == gameboard[r][2]
                    && gameboard[r][0] != 0) {
                iswinner = true;
                winType=new int[]{r,0,1};
                break;
            }
        }
        //column check or vertical checking
        for(int c=0;c<3;c++){
            if (gameboard[0][c] == gameboard[1][c] && gameboard[0][c] == gameboard[2][c]
                    && gameboard[0][c] != 0) {
                iswinner = true;
                winType=new int[]{0,c,2};
                break;
            }
        }
        //diagonal check
        if(gameboard[0][0]==gameboard[1][1] && gameboard[0][0]==gameboard[2][2]
        && gameboard[0][0]!=0){
            iswinner=true;
            winType=new int[]{0,2,3};
        }
        //other diagonal check
        if(gameboard[0][2]==gameboard[1][1] && gameboard[0][2]==gameboard[2][0]
        && gameboard[0][2]!=0){
            iswinner=true;
            winType=new int[]{2,2,4};
        }

        int boardfilled=0;
        for(int r=0;r<3;r++){
            for(int c=0;c<3;c++){
                if(gameboard[r][c]!=0)
                    boardfilled+=1;
            }
        }

        //now check winner
        if(iswinner){
            playerbtn.setVisibility(View.VISIBLE);
            homebtn.setVisibility(View.VISIBLE);
            playerTurn.setText(playername[player-1]+" won!!!");
            return true;
        }
        else if (boardfilled==9){
            playerbtn.setVisibility(View.VISIBLE);
            homebtn.setVisibility(View.VISIBLE);
            playerTurn.setText("TieGame !!!!");
            return false;
        }
       return false;
    }

    public int[] getWinType() {
        return winType;
    }
}
