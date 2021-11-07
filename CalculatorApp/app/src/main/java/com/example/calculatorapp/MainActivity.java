package com.example.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private double firstNumber;
    private double secondNumber;
    private double result;
    private String operator;
    private String answer;
    private String eventNumber;

    private TextView textDisplay;
    private TextView textView;
    private boolean hasResult;
    private boolean hasFirstNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textDisplay = findViewById(R.id.textView2);


        findViewById(R.id.button_0).setOnClickListener(this);
        findViewById(R.id.button_1).setOnClickListener(this);
        findViewById(R.id.button_2).setOnClickListener(this);
        findViewById(R.id.button_3).setOnClickListener(this);
        findViewById(R.id.button_4).setOnClickListener(this);
        findViewById(R.id.button_5).setOnClickListener(this);
        findViewById(R.id.button_6).setOnClickListener(this);
        findViewById(R.id.button_7).setOnClickListener(this);
        findViewById(R.id.button_8).setOnClickListener(this);
        findViewById(R.id.button_9).setOnClickListener(this);
        findViewById(R.id.button_plus).setOnClickListener(this);
        findViewById(R.id.button_sub).setOnClickListener(this);
        findViewById(R.id.button_multi).setOnClickListener(this);
        findViewById(R.id.button_div).setOnClickListener(this);
        findViewById(R.id.button_equal).setOnClickListener(this);
        findViewById(R.id.button_dot).setOnClickListener(this);
        findViewById(R.id.button_opposite).setOnClickListener(this);
        findViewById(R.id.button_ce).setOnClickListener(this);
        findViewById(R.id.button_c).setOnClickListener(this);
        findViewById(R.id.button_back).setOnClickListener(this);
    }

    public void doButtonNumber(int id){
        Button btn = findViewById(id);
        if(hasResult){
            textDisplay.setText(null);
            textView.setText(null);
            hasResult = false;
        }
        if(hasFirstNumber){
            textDisplay.setText(null);
            hasFirstNumber = false;
        }

        eventNumber = textDisplay.getText().equals("0") ? btn.getText().toString() : textDisplay.getText().toString() + btn.getText();
        textDisplay.setText(eventNumber);
    }

    public void doButtonOperator(){
        hasResult = false;
        hasFirstNumber = true;
        firstNumber = Double.parseDouble(textDisplay.getText().toString());
        DecimalFormat df = new DecimalFormat("###,###.####");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        textView.setText(df.format(firstNumber) + operator);
    }

    @Override
    public void onClick(View view) {
        DecimalFormat df = new DecimalFormat("###,###.####");
        df.setDecimalFormatSymbols(DecimalFormatSymbols.getInstance(Locale.ENGLISH));
        switch (view.getId()){
            case R.id.button_0:
                doButtonNumber(R.id.button_0);
                break;
            case R.id.button_1:
                doButtonNumber(R.id.button_1);
                break;
            case R.id.button_2:
                doButtonNumber(R.id.button_2);
                break;
            case R.id.button_3:
                doButtonNumber(R.id.button_3);
                break;
            case R.id.button_4:
                doButtonNumber(R.id.button_4);
                break;
            case R.id.button_5:
                doButtonNumber(R.id.button_5);
                break;
            case R.id.button_6:
                doButtonNumber(R.id.button_6);
                break;
            case R.id.button_7:
                doButtonNumber(R.id.button_7);
                break;
            case R.id.button_8:
                doButtonNumber(R.id.button_8);
                break;
            case R.id.button_9:
                doButtonNumber(R.id.button_9);
                break;
            case  R.id.button_plus:
                operator = "+";
                doButtonOperator();
                break;
            case  R.id.button_sub:
                operator = "-";
                doButtonOperator();
                break;
            case R.id.button_multi:
                operator = "x";
                doButtonOperator();
                break;
            case R.id.button_div:
                operator = "/";
                doButtonOperator();
                break;
            case R.id.button_equal:
                hasResult = true;
                 if(operator == null){
                    result = Double.parseDouble(eventNumber);
                    textDisplay.setText(df.format(result));
                    break;
                 }
                secondNumber = Double.parseDouble(eventNumber);
                if(operator.equals("+")){
                    result = firstNumber + secondNumber;
                    textDisplay.setText(df.format(result));
                }
                else if(operator.equals("-")){
                    result = firstNumber - secondNumber;
                    textDisplay.setText(df.format(result));
                }
                else if(operator.equals("x")){
                    result = firstNumber * secondNumber;
                    textDisplay.setText(df.format(result));
                }
                else if(operator.equals("/")){
                    result = (double) firstNumber / secondNumber;
                    textDisplay.setText(df.format(result));
                }

                String str2 = df.format(firstNumber) + operator + df.format(secondNumber) + "=";
                textView.setText(str2);
                operator = null;
                break;

            case R.id.button_dot:
                Button btn = findViewById(R.id.button_dot);
                if(hasResult){
                    textDisplay.setText("0");
                    textView.setText(null);
                    hasResult = false;
                }
                if(hasFirstNumber){
                    textDisplay.setText("0");
                    hasFirstNumber = false;
                }

                eventNumber = textDisplay.getText().toString() + btn.getText();
                textDisplay.setText(eventNumber);
                break;
            case R.id.button_back:
                String backspace = null;
                if(!hasResult){
                    if(textDisplay.getText().length() > 1) {
                        StringBuilder str = new StringBuilder(textDisplay.getText());
                        str.deleteCharAt(textDisplay.getText().length() - 1);
                        backspace = str.toString();
                        textDisplay.setText(backspace);
                    }
                    else {
                        textDisplay.setText("0");
                    }
                }
                else{
                    textView.setText(null);
                }

                break;
            case R.id.button_ce:
                if(hasResult){
                    textView.setText(null);
                }
                textDisplay.setText("0");
                break;
            case R.id.button_c:
                textDisplay.setText("0");
                textView.setText(null);
                break;
            case R.id.button_opposite:
                double number = Double.parseDouble(textDisplay.getText().toString());
                number = number * -1;
                textDisplay.setText(df.format(number));
                break;
            default:

                break;
        }

    }

//    public void btn0(View view) {
//        Button btn0 = findViewById(R.id.button_0);
//        String eventNumber = textDisplay.getText().toString() + btn0.getText();
//        textDisplay.setText(eventNumber);
//    }
//
//    public void btn1(View view) {
//        Button btn1 = findViewById(R.id.button_1);
//        String eventNumber = textDisplay.getText().toString() + btn1.getText();
//        textDisplay.setText(eventNumber);
//    }
//
//    public void btn2(View view) {
//        Button btn2 = findViewById(R.id.button_2);
//        String eventNumber = textDisplay.getText().toString() + btn2.getText();
//        textDisplay.setText(eventNumber);
//    }
//    public void btn3(View view) {
//        Button btn = findViewById(R.id.button_3);
//        String eventNumber = textDisplay.getText().toString() + btn.getText();
//        textDisplay.setText(eventNumber);
//    }
//    public void btn4(View view) {
//        Button btn2 = findViewById(R.id.button_4);
//        String eventNumber = textDisplay.getText().toString() + btn2.getText();
//        textDisplay.setText(eventNumber);
//    }
//    public void btn5(View view) {
//        Button btn2 = findViewById(R.id.button_5);
//        String eventNumber = textDisplay.getText().toString() + btn2.getText();
//        textDisplay.setText(eventNumber);
//    }
//    public void btn6(View view) {
//        Button btn2 = findViewById(R.id.button_6);
//        String eventNumber = textDisplay.getText().toString() + btn2.getText();
//        textDisplay.setText(eventNumber);
//    }
//    public void btn7(View view) {
//        Button btn2 = findViewById(R.id.button_7);
//        String eventNumber = textDisplay.getText().toString() + btn2.getText();
//        textDisplay.setText(eventNumber);
//    }


}