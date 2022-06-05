package com.example.tictaktoe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class tictaktoeboard extends View {

    //four variable to store the color
    private final int boardcolor;
    private final int xcolor;
    private final int ocolor;
    private final int winnerlinecolor;

    private boolean winningline=false;
    private final GameLogic game;

    private final Paint paint=new Paint();
    private int cellsize = getWidth()/3;

    public tictaktoeboard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        //we are extracting the color from the tictaktoeboard
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs,R.styleable.tictaktoeboard,
                0,0);
      game=new GameLogic();
        try{
           //now we initilized the integer we created above
           boardcolor=a.getInteger(R.styleable.tictaktoeboard_boardcolor,0);
           xcolor=a.getInteger(R.styleable.tictaktoeboard_Xcolor,0);
           ocolor=a.getInteger(R.styleable.tictaktoeboard_Ocolor,0);
           winnerlinecolor=a.getInteger(R.styleable.tictaktoeboard_winnerlinecolor,0);
        }
        finally {
            a.recycle();
        }

    }
    @Override
    protected void onMeasure(int width,int height){
        super.onMeasure(width,height);
        //we will store the minimum dimenstion of the view and make our board of that size
        int dimensions=Math.min(getMeasuredHeight(),getMeasuredWidth());
       cellsize=dimensions/3;
        setMeasuredDimension(dimensions,dimensions);
    }

    @Override
    protected void onDraw(Canvas canvas){
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);

        //creating a method to make a gameboard
        drawGameBoard(canvas);
         //making new method
        drawmarkers(canvas);
        if(winningline){
            paint.setColor(winnerlinecolor);
            drawWinningline(canvas);
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){
        //get x and y position from user touch
        float x= event.getX();
        float y=event.getY();

        //we should update when user touch the board
        int action=event.getAction();
        if(action==MotionEvent.ACTION_DOWN){
            int row=(int)Math.ceil(y/cellsize);
            int col=(int)Math.ceil(x/cellsize);

            if(!winningline){
            if(game.updateGameBoard(row, col)) {
                invalidate();

                if(game.winnerCheck()){
                    winningline=true;
                    invalidate();
                }

                //updating the players
                if (game.getPlayer() % 2 == 0) {
                    game.setPlayer(game.getPlayer() - 1);
                } else {
                    game.setPlayer(game.getPlayer() + 1);
                }
            }
            }


            invalidate();
            return true;
        }
        return false;
    }


    private void drawGameBoard(Canvas canvas){
        paint.setColor(boardcolor);
        paint.setStrokeWidth(16);


        for (int c=1; c<3; c++){
            canvas.drawLine(cellsize*c, 0, cellsize*c, canvas.getHeight(), paint);
        }

        for (int r=1; r<3; r++){
            canvas.drawLine(0, cellsize*r, canvas.getWidth(), cellsize*r, paint);
        }
    }

    private void drawmarkers(Canvas canvas){
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
               if(game.getGameboard()[r][c]!=0){
                   if(game.getGameboard()[r][c]==1){
                       drawx(canvas,r,c);
                   }
                   else {
                       drawo(canvas,r,c);
                   }
               }
            }
        }
    }

    private void drawHorizontalline(@NonNull Canvas canvas, int row, int col){
        canvas.drawLine(col,row*cellsize+(float)cellsize/2,cellsize*3,
                row*cellsize+(float)cellsize/2,paint);
    }

    private void drawverticalline(@NonNull Canvas canvas, int row, int col){
        canvas.drawLine(col*cellsize+(float)cellsize/2,row
        ,col*cellsize+(float)cellsize/2,cellsize*3,paint);
    }

    private void drawdiagonallinepos(@NonNull Canvas canvas){
        canvas.drawLine(0,cellsize*3,cellsize*3,0,paint);
    }

    private void drawdiagonallineneg(@NonNull Canvas canvas){
        canvas.drawLine(0,0,cellsize*3,cellsize*3,paint);
    }

    private void drawx(@NonNull Canvas canvas, int row, int col){
        paint.setColor(xcolor);
        canvas.drawLine((float)((col+1)*cellsize-cellsize*0.2),
                        (float)(row*cellsize+cellsize*0.2),
                         (float)(col*cellsize+cellsize*0.2),
                (float)((row+1)*cellsize-cellsize*0.2),paint);

        canvas.drawLine((float)(col*cellsize+cellsize*0.2),
                (float)(row*cellsize+cellsize*0.2),
                (float)((col+1)*cellsize-cellsize*0.2),
                (float)((row+1)*cellsize-cellsize*0.2),paint);
    }
   private void drawo(@NonNull Canvas canvas,int row,int col){
        paint.setColor(ocolor);
        canvas.drawOval((float)(col*cellsize+cellsize*0.2),
                        (float)(row*cellsize+cellsize*0.2),
                         (float)(((col*cellsize)+cellsize)-cellsize*0.2),
                         (float)(((row*cellsize)+cellsize)-cellsize*0.2),
                         paint);
   }

   public void setupGame(Button playAgain, Button homeBtn, TextView playerDisplay,String[] names){
         game.setPlayerbtn(playAgain);
         game.setHomebtn(homeBtn);
         game.setPlayerTurn(playerDisplay);
         game.setPlayername(names);
   }
private void drawWinningline(Canvas canvas){
        int row=game.getWinType()[0];
        int col=game.getWinType()[1];

        switch (game.getWinType()[2]){
            case 1:
                drawHorizontalline(canvas,row,col);
                break;
            case 2:
                drawverticalline(canvas,row,col);
                break;
            case 3:
                drawdiagonallineneg(canvas);
                break;
            case 4:
                drawdiagonallinepos(canvas);
        }
}

   public void resetGame(){
        game.resetGame();
        winningline=false;
   }

}
