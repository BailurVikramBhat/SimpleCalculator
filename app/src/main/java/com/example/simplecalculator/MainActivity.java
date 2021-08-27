package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

/**
 * @author Vikram Bhat
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button[] numberButtons;

    Button[] operations;

    TextView updateAnswer;


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
                findViewById(R.id.buttonPeriod),
                findViewById(R.id.delete),
                findViewById(R.id.equalTo)
        };
        for(Button b: operations) {
            b.setOnClickListener(this);
        }

        updateAnswer = findViewById(R.id.editText);



    }

    @Override
    public void onClick(View view) {
        int idGotFrommView = view.getId();

        if(idGotFrommView == R.id.button0) {
            updateAnswer.append("0");
        }
        else if(idGotFrommView == R.id.button1) {
            updateAnswer.append("1");
        }
        else if(idGotFrommView == R.id.button2) {
            updateAnswer.append("2");
        }
        else if(idGotFrommView == R.id.button3) {
            updateAnswer.append("3");
        }
        else if(idGotFrommView == R.id.button4) {
            updateAnswer.append("4");
        }
        else if(idGotFrommView == R.id.button5) {
            updateAnswer.append("5");
        }
        else if(idGotFrommView == R.id.button6) {
            updateAnswer.append("6");
        }
        else if(idGotFrommView == R.id.button7) {
            updateAnswer.append("7");
        }
        else if(idGotFrommView == R.id.button8) {
            updateAnswer.append("8");
        }
        else if(idGotFrommView == R.id.button9) {
            updateAnswer.append("9");
        }
        else if(idGotFrommView == R.id.button00) {
            updateAnswer.append("00");
        }
        else if(idGotFrommView == R.id.buttonPeriod) {
            updateAnswer.append(".");
        }
        else if(idGotFrommView == R.id.add) {
            updateAnswer.append("+");
        }
        else if(idGotFrommView == R.id.subtract) {
            updateAnswer.append("-");
        }
        else if(idGotFrommView == R.id.multiply) {
            updateAnswer.append("x");
        }
        else if(idGotFrommView == R.id.divide) {
            updateAnswer.append("/");
        }
        else if(idGotFrommView == R.id.clear) {
            updateAnswer.setText("");
        }
        else if(idGotFrommView == R.id.delete) {
            String cache = updateAnswer.getText().toString();
            updateAnswer.setText(cache.replaceFirst(".$", ""));
        }
        else if(idGotFrommView == R.id.modulus) {
            updateAnswer.append("%");
        }
        else if(idGotFrommView == R.id.equalTo) {
            /*

            TODO: Handle the case where input can be empty and operators are there

            * */


            String expression = updateAnswer.getText().toString();
            if(expression.isEmpty()) {
                updateAnswer.setText("");
            }
            else {

                expression = expression.replaceAll("x", "*");

                updateAnswer.setText(Integer.toString(evaluate(expression)));
            }
        }




    }

    public static int evaluate(String expression) {

        // remove leading zeroes from string
        expression = expression.replaceFirst("^0+(?!$)", "");
        char[] tokens = expression.toCharArray();

        Stack<Integer> operands = new Stack<>();
        Stack<Character> operators = new Stack<>();

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
            else if(tokens[i] == '+' || tokens[i] =='-' || tokens[i] == '*' || tokens[i] == '/' || tokens[i]=='%') {
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



    public static int performOperation(char operator, int operand2, int operand1) {

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
                    return Integer.MIN_VALUE; // how to show Can't divide by zero?
                    // TODO: show can't divide by zero
                }
                return operand1/operand2;

        }
        return 0;
    }

    public static boolean hasPrecedence(char operator1, char operator2) {

        if(operator1 == '(' || operator2==')') {
            return false;
        }
        return (operator1 != '*' && operator1 != '/' && operator1!='%') || (operator2 != '+' && operator2 != '-');
    }
}