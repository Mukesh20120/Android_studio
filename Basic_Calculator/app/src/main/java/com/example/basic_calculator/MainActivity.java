package com.example.basic_calculator;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

  private EditText display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display=findViewById(R.id.input);
         display.setShowSoftInputOnFocus(false);

         display.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 if(getString(R.string.dispaly).equals(display.getText().toString()))
                     display.setText("");
             }
         });
    }
    public void updatetext(String addtostring){
        String oldstring=display.getText().toString();
        int cursorstart=display.getSelectionStart();
        String leftstr=oldstring.substring(0,cursorstart);
        String rightstr=oldstring.substring(cursorstart);
        if(getString(R.string.dispaly).equals(display.getText().toString())){
            display.setText(addtostring);
        }
        else{
            display.setText(String.format("%s%s%s",leftstr,addtostring,rightstr));
        }
        display.setSelection(cursorstart+1);
    }

    public void zerobtn(View view){
       updatetext("0");
    }public void onebtn(View view){
      updatetext("1");
    }public void twobtn(View view){
        updatetext("2");
    }public void threebtn(View view){
         updatetext("3");
    }public void fourbtn(View view){
        updatetext("4");
    }public void fivebtn(View view){
         updatetext("5");
    }public void sixbtn(View view){
          updatetext("6");
    }public void sevenbtn(View view){
          updatetext("7");
    }public void eightbtn(View view){
          updatetext("8");
    }public void ninebtn(View view){
         updatetext("9");
    }
    public void parenthesisbtn(View view){
         int cursor=display.getSelectionStart();
         int len=display.getText().length();
         int openbracket=0;
         int closebracket=0;
         //now we need to count the open and close bracket
        for(int i=0;i<cursor;i++){
            if(display.getText().toString().charAt(i) == '('){
                openbracket+=1;
            } if(display.getText().toString().charAt(i) == ')') {
                closebracket += 1;
            }
        }

        if(openbracket==closebracket || display.getText().toString().charAt(len-1)=='('){
            updatetext("(");

        }else if(openbracket>closebracket && !(display.getText().toString().charAt(len-1) =='(')){
            updatetext(")");

        }
        display.setSelection(cursor+1);
    } public void exponentialbtn(View view){
        updatetext("^");
    } public void dividebtn(View view){
        updatetext("/");
    } public void multiplicationbtn(View view){
        updatetext("*");
    } public void subtractbtn(View view){
        updatetext("-");
    } public void plusbtn(View view){
        updatetext("+");
    } public void dotbtn(View view){
        updatetext(".");
    }public void plusminusbtn(View view){
        updatetext("+/-");
    }public void equalbtn(View view){
       String expe=display.getText().toString();

       Expression exp=new Expression(expe);
       String result=String.valueOf(exp.calculate());
       display.setText(result);
       display.setSelection(result.length());

    }public void backspacebtn(View view){
        int cursor=display.getSelectionStart();
        int len=display.getText().length();
        if(cursor!=0 && len!=0){
            SpannableStringBuilder selector= (SpannableStringBuilder) display.getText();
            selector.replace(cursor-1,cursor,"");
            display.setText(selector);
            display.setSelection(cursor-1);
        }
    }


    public void clearbtn(View view){
        display.setText("");
    }
}