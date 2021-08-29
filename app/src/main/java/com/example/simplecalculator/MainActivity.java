package com.example.simplecalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.Locale;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * @author Vikram Bhat
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[] numberButtons;

    Button[] operations;


    TextView updateAnswer;

    TextView answer;

    boolean equalButtonPressed, divisionByZero, hadNeg, OneOperator, hasOpenParanthesis, doubleRem;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberButtons = new Button[] {

                findViewById(R.id.button0),
                findViewById(R.id.button1),
                findViewById(R.id.button2),
                findViewById(R.id.button3),
                findViewById(R.id.button4),
                findViewById(R.id.button5),
                findViewById(R.id.button6),
                findViewById(R.id.button7),
                findViewById(R.id.button8),
                findViewById(R.id.button9)

        };
        for(Button b: numberButtons) {
            b.setOnClickListener(this);
        }

        operations = new Button[] {
                findViewById(R.id.add),
                findViewById(R.id.subtract),
                findViewById(R.id.multiply),
                findViewById(R.id.divide),
                findViewById(R.id.modulus),
                findViewById(R.id.clear),
                findViewById(R.id.buttonPeriod),
                findViewById(R.id.button00),
                findViewById(R.id.delete),
                findViewById(R.id.equalTo)
        };
        for(Button b: operations) {
            b.setOnClickListener(this);
        }

        updateAnswer = findViewById(R.id.editText);

        answer = findViewById(R.id.answer);

        equalButtonPressed = false;
        divisionByZero = false;
        hadNeg = false;
        OneOperator = false;
        hasOpenParanthesis = false;
        doubleRem = false;




    }

    @Override
    public void onClick(View view) {
        int idGotFrommView = view.getId();

        if(idGotFrommView == R.id.button0) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("0");
        }
        else if(idGotFrommView == R.id.button1) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("1");
        }
        else if(idGotFrommView == R.id.button2) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("2");
        }
        else if(idGotFrommView == R.id.button3) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("3");
        }
        else if(idGotFrommView == R.id.button4) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("4");
        }
        else if(idGotFrommView == R.id.button5) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("5");
        }
        else if(idGotFrommView == R.id.button6) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("6");
        }
        else if(idGotFrommView == R.id.button7) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("7");
        }
        else if(idGotFrommView == R.id.button8) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("8");
        }
        else if(idGotFrommView == R.id.button9) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("9");
        }
        else if(idGotFrommView == R.id.button00) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append("00");
        }

        else if(idGotFrommView == R.id.buttonPeriod) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            updateAnswer.append(".");
        }
        else if(idGotFrommView == R.id.add) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            answer.setText("");
            updateAnswer.append("+");
        }
        else if(idGotFrommView == R.id.subtract) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            answer.setText("");
            updateAnswer.append("-");
        }
        else if(idGotFrommView == R.id.multiply) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            answer.setText("");
            updateAnswer.append("\u00D7");
        }
        else if(idGotFrommView == R.id.divide) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            answer.setText("");
            updateAnswer.append("\u00F7");
        }
        else if(idGotFrommView == R.id.clear) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
            }
            equalButtonPressed = false;
            answer.setText("");
            updateAnswer.setText("");
        }
        else if(idGotFrommView == R.id.delete) {
            hasOpenParanthesis = false;

            if(answer.getText().toString().equals("Can't divide by Zero") || answer.getText().toString().equals("invalid")) {
                updateAnswer.setText("");
                answer.setText("");
            }
            else if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString().replaceFirst(".$", ""));
                answer.setText("");
                equalButtonPressed = false;
            }
            else if(answer.getText().toString().equals("")) {
                String cache = updateAnswer.getText().toString();
                updateAnswer.setText(cache.replaceFirst(".$", ""));
            }
            else {
                String cache = answer.getText().toString();
                answer.setText(cache.replaceFirst(".$", ""));
            }


        }
        else if(idGotFrommView == R.id.modulus) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("%");
                equalButtonPressed = false;
            }
            equalButtonPressed = false;
            answer.setText("");
            updateAnswer.append("%");
        }
        else if(idGotFrommView == R.id.equalTo) {
            equalButtonPressed = true;
            String expression = updateAnswer.getText().toString();
            if(expression.isEmpty() || expression.startsWith("invalid")) {
                updateAnswer.setText("");
            }
            else {
                expression = expression.replaceAll("\u00D7", "*");
                expression = expression.replaceAll("\u00F7", "/");
                updateAnswer.setText("");
                if(isValid(expression)) {
                    Double doubleans = eval(expression);
                    if(divisionByZero) {
                       answer.setTextColor(Color.parseColor("#FF0000"));
                       answer.setText("Can't divide by Zero");
                       divisionByZero = false;
                    }
                    else if(doubleRem) {
                        answer.setTextColor(Color.parseColor("#FF0000"));
                        answer.setText("Can't find % for doubles");
                        doubleRem = false;
                    }
                    else {
                        answer.setTextColor(Color.parseColor("#ffff4444"));
                        if(doubleans == Math.floor(doubleans)) {
                            answer.setText(String.format(Locale.US, "%.0f", doubleans));
                        }
                        else {
                            answer.setText(Double.toString(doubleans));
                        }
                    }
                }
                else {
                    answer.setTextColor(Color.parseColor("#FF0000"));
                    answer.setText("invalid");
                }

            }
        }
    }


    public boolean isValid(String s) {

        char[] tokens = s.toCharArray();
        int ans = 0;
        String storage = "+-*/%";
        if(!Pattern.matches("-?\\d+([-+*%/.()]-?\\d+)*", s)) {
            return false;
        }
        if(s.length() == 1 && storage.contains(Character.toString(tokens[0]))) return false;
        for(int i=0; i<tokens.length; i++) {
            if(tokens[i] == '+' || tokens[i] == '-' || tokens[i] =='*' || tokens[i] == '/' || tokens[i]=='%') ans++;
        }
        if(ans==1) OneOperator = true;
        for(int i=0; i<tokens.length-1; i++) {
            if(storage.contains(Character.toString(tokens[i])) && storage.contains(Character.toString(tokens[i+1]))) {
                return false;
            }

        }
        return true;


    }

    int order(char operator) {
        if(operator == '+' || operator == '-') {
            return 1;
        }
        if(operator == '*'  || operator == '/' || operator == '%') {
            return 2;
        }
        return 0;
    }

    double calculation(double op2, char op, double op1) {
        if(op == '-') return op1 - op2;
        if(op == '+') return op1 + op2;
        if(op == '*') return op1 * op2;
        if(op == '%') {
            if(op1 == Math.floor(op1) && op2 == Math.floor(op2)) {
                return op1%op2;
            }
            else doubleRem = true;
        }
        if(op == '/') {

            if(op2 == 0) {
                divisionByZero = true;
            }
            else return op1 / op2;
        }
        return 0;
    }

    double eval(String expression) {
        int len = expression.length();
        char[] tokens = expression.toCharArray();
        Stack<Double> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();
        for(int i=0; i<len; i++) {
            if(tokens[i] == ' ') {
                continue;
            }
            else if(Character.isDigit(tokens[i])) {
                StringBuilder ans = new StringBuilder();
                while(i<len && (Character.isDigit(tokens[i]))) {
                    ans.append(tokens[i]);
                    i++;
                }
                if(i<len && tokens[i] == '.') {
                    i++;
                    ans.append(".");
                    while(i<len && Character.isDigit(tokens[i])) {
                        ans.append(tokens[i]);
                        i++;
                    }
                }
                operands.push(Double.parseDouble(ans.toString()));
                System.out.println(operands.peek());
                i--;
            }
            else if(tokens[i] == '(') {
                operator.push(tokens[i]);
            }
            else if(tokens[i] == ')') {
                while(!operator.empty() && operator.peek()!='(') {
                    double a = operands.pop();
                    double b = operands.pop();
                    char c = operator.pop();
                    operands.push(calculation(a, c, b));
                }
                operator.pop();
            }
            else {
                String minus = "";
                if(tokens[i] == '-') {
                    if(!operator.empty()) {
                        if(operator.peek() == '(') {
                            operands.push(0.0);
                        }
                        else if(i==0) {
                            // first num is negative.
                            double b = operands.pop();
                            operands.push(Double.parseDouble("-"+b));
                        }
                    }

                }
                while(!operator.empty() && order(operator.peek())>=order(tokens[i])) {
                    double a = operands.pop();
                    double b;
                    if(operands.empty()) {
                        b=0;
                    }
                    else {
                        b = operands.pop();
                    }
                    char c = operator.pop();
                    operands.push(calculation(a, c, b));
                }
                operator.push(tokens[i]);
            }

        }
        while(!operator.empty()) {
            double a = operands.pop();
            double b;
            if(operands.empty()) {
                b=0;
            }
            else b = operands.pop();
            char c = operator.pop();
            operands.push(calculation(a, c, b));
        }
        return operands.peek();
    }

}