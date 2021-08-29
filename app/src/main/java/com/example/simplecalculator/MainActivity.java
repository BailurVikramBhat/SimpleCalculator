package com.example.simplecalculator;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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

    boolean equalButtonPressed, divisionByZero, hadNeg, OneOperator, hasOpenParanthesis;





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

        /*else if(idGotFrommView == R.id.buttonPeriod) {
            if(equalButtonPressed) {
                updateAnswer.setText(answer.getText().toString());
                answer.setText("");
                equalButtonPressed = false;
            }

            if(!hasOpenParanthesis) {
                updateAnswer.append("(");
                hasOpenParanthesis = true;
            }
            else {
                updateAnswer.append(")");
                hasOpenParanthesis = false;
            }


        }*/
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
                answer.setText("");
            }
            equalButtonPressed = false;
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
                    int ans = evaluate(expression);
                    if(divisionByZero) {
                       answer.setTextColor(Color.parseColor("#FF0000"));
                       answer.setText("Can't divide by Zero");
                       divisionByZero = false;
                    }
                    else if(hadNeg && OneOperator){
                        answer.setTextColor(Color.parseColor("#ffff4444"));
                        answer.setText("-"+Integer.toString(ans));
                        hadNeg = false;
                        OneOperator = false;
                    }
                    else {
                        answer.setTextColor(Color.parseColor("#ffff4444"));
                        answer.setText(Integer.toString(ans));
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
        if(!Pattern.matches("-?\\d+([-+*%/]-?\\d+)*", s)) {
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



















    public int evaluate(String expression) {

        // remove leading zeroes from string
        expression = expression.replaceFirst("^0+(?!$)", "");
        char[] tokens = expression.toCharArray();
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();
        if(expression.charAt(0) == '-' && expression.length()>1) {
            hadNeg = true;
        }

        for(int i=0; i<tokens.length; i++) {




            // user can enter spaces through keyboard
            if(tokens[i] == ' ') continue;

            if(tokens[i]>='0' && tokens[i]<='9') {

                StringBuilder moreThanOneDigitNumber = new StringBuilder();

                while(i<tokens.length && tokens[i]>='0' && tokens[i]<='9') {
                    moreThanOneDigitNumber.append(tokens[i++]);
                }

                operands.push(Integer.parseInt(moreThanOneDigitNumber.toString()));

                i--; // as we did i++ as index, we need to come back one step back for next iteration
            }

            else if(tokens[i] == '(') {
                operators.push(tokens[i]); // we don't care opening parantheses
            }
            else if(tokens[i] == ')') {
                while(operators.peek()!='(') {
                    operands.push(performOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                operators.pop();
            }
            else if(tokens[i] == '+' || (tokens[i] =='-' && i!=0) || tokens[i] == '*' || tokens[i] == '/' || tokens[i]=='%') {
                // check operator precedence
                while(!operators.empty() && hasPrecedence(tokens[i], operators.peek())) {
                    operands.push(performOperation(operators.pop(), operands.pop(), operands.pop()));
                }
                // push the current operator
                operators.push(tokens[i]);
            }
        }
        // we parsed full expression: YAY!
        while(!operators.empty()) {
            operands.push(performOperation(operators.pop(), operands.pop(), operands.pop()));
        }
        return operands.pop(); // has the final ans
    }



    public int performOperation(char operator, int operand2, int operand1) {

        /*

        TODO : If input expression is: 10 + - 5
        it should show invalid. It is crashing. How to do?
        * */

        switch(operator) {
            case '+':
                return operand1+operand2;
            case '-':
                return operand1-operand2;
            case '*':
                return operand1*operand2;
            case '%':
                return operand1%operand2;
            case '/':
                if(operand2 == 0) {
                    divisionByZero = true;
                    return Integer.MIN_VALUE; // how to show Can't divide by zero?
                    // TODO: show can't divide by zero
                }
                return operand1/operand2;

        }
        return 0;
    }

    public boolean hasPrecedence(char operator1, char operator2) {

        if(operator1 == '(' || operator2==')') {
            return false;
        }
        return (operator1 != '*' && operator1 != '/' && operator1!='%') || (operator2 != '+' && operator2 != '-');
    }
}