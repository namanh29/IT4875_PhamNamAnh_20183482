package com.example.calculatorfragment.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatorfragment.R;
import com.example.calculatorfragment.databinding.FragmentCalculatorBinding;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CalculatorFragment extends Fragment implements View.OnClickListener{

    private CalculatorViewModel calculatorViewModel;
    private FragmentCalculatorBinding binding;

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

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        calculatorViewModel =
                new ViewModelProvider(this).get(CalculatorViewModel.class);

        binding = FragmentCalculatorBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        textView = root.findViewById(R.id.textView);
        textDisplay = root.findViewById(R.id.textView2);

        root.findViewById(R.id.button_0).setOnClickListener(this);
        root.findViewById(R.id.button_1).setOnClickListener(this);
        root.findViewById(R.id.button_2).setOnClickListener(this);
        root.findViewById(R.id.button_3).setOnClickListener(this);
        root.findViewById(R.id.button_4).setOnClickListener(this);
        root.findViewById(R.id.button_5).setOnClickListener(this);
        root.findViewById(R.id.button_6).setOnClickListener(this);
        root.findViewById(R.id.button_7).setOnClickListener(this);
        root.findViewById(R.id.button_8).setOnClickListener(this);
        root.findViewById(R.id.button_9).setOnClickListener(this);
        root.findViewById(R.id.button_plus).setOnClickListener(this);
        root.findViewById(R.id.button_sub).setOnClickListener(this);
        root.findViewById(R.id.button_multi).setOnClickListener(this);
        root.findViewById(R.id.button_div).setOnClickListener(this);
        root.findViewById(R.id.button_equal).setOnClickListener(this);
        root.findViewById(R.id.button_dot).setOnClickListener(this);
        root.findViewById(R.id.button_opposite).setOnClickListener(this);
        root.findViewById(R.id.button_ce).setOnClickListener(this);
        root.findViewById(R.id.button_c).setOnClickListener(this);
        root.findViewById(R.id.button_back).setOnClickListener(this);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void doButtonNumber(int id){
        Button btn = getActivity().findViewById(id);
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
                Button btn = view.findViewById(R.id.button_dot);
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
}