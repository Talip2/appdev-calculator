package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {


    private StringBuilder inputLine;
    Calculator calculator = null;
    Button btnZero;
    Button btnOne;
    Button btnTwo;
    Button btnThree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;
    Button btnNine;
    Button btnPlus;
    Button btnMinus;
    Button btnMultiply;
    Button btnDivide;
    Button btnDecimal;
    Button btnEqual;
    EditText input;
    EditText result;
    boolean decimalPressed = false;
    private boolean isEqualButtonPressed = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputLine = new StringBuilder();
        setContentView(R.layout.activity_calculator_exercise);
        input = (EditText) findViewById(R.id.input);
        result = (EditText) findViewById(R.id.result);
        btnZero = (Button) findViewById(R.id.btnCalcZero);
        btnOne = (Button) findViewById(R.id.btnCalcOne);
        btnTwo = (Button) findViewById(R.id.btnCalcTwo);
        btnThree = (Button) findViewById(R.id.btnCalcThree);
        btnFour = (Button) findViewById(R.id.btnCalcFour);
        btnFive = (Button) findViewById(R.id.btnCalcFive);
        btnSix = (Button) findViewById(R.id.btnCalcSix);
        btnSeven = (Button) findViewById(R.id.btnCalcSeven);
        btnEight = (Button) findViewById(R.id.btnCalcEight);
        btnNine = (Button) findViewById(R.id.btnCalcNine);
        btnPlus = (Button) findViewById(R.id.btnCalcPlus);
        btnMinus = (Button) findViewById(R.id.btnCalcMinus);
        btnMultiply = (Button) findViewById(R.id.btnCalcMultiply);
        btnDivide = (Button) findViewById(R.id.btnCalcDivide);
        btnDecimal = (Button) findViewById(R.id.btnCalcDecimal);
        btnEqual = (Button) findViewById(R.id.btnCalcEqual);

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("0");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }

        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("1");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("2");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("3");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("4");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });


        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("5");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("6");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("7");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("8");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("9");
                input.setText(inputLine);
                if (!isEqualButtonPressed && inputLine.length() > 3) {
                    updateResultText();
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimalPressed = false;
                if (endsWithOperator(inputLine)) {
                    inputLine.delete(inputLine.length() - 3, inputLine.length());
                }
                inputLine.append(" + ");
                input.setText(inputLine);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimalPressed = false;
                if (endsWithOperator(inputLine)) {
                    inputLine.delete(inputLine.length() - 3, inputLine.length());
                }
                inputLine.append(" - ");
                input.setText(inputLine);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                decimalPressed = false;
                if (endsWithOperator(inputLine)) {
                    inputLine.delete(inputLine.length() - 3, inputLine.length());
                }
                inputLine.append(" × ");
                input.setText(inputLine);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                decimalPressed = false;
                if (endsWithOperator(inputLine)) {
                    inputLine.delete(inputLine.length() - 3, inputLine.length());
                }
                inputLine.append(" ÷ ");
                input.setText(inputLine);
            }
        });


        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isEqualButtonPressed = true;
                String expression = inputLine.toString().trim();
                calculator = new Calculator(expression);
                Double res = calculator.Calculate();

                if (res == Math.floor(res)) {
                    inputLine.setLength(0);
                    inputLine.append(res.intValue());
                    result.setText(String.valueOf(res.intValue()));
                } else {
                    inputLine.setLength(0);
                    inputLine.append(res);
                    result.setText(String.valueOf(res));
                }
            }
        });


        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (endsWithDecimal(inputLine)) {
                    inputLine.deleteCharAt(inputLine.length() - 1);
                    input.setText(inputLine);
                    decimalPressed = false;
                } else {
                    if(!decimalPressed) {
                        inputLine.append(".");
                        input.setText(inputLine);
                        decimalPressed = true;
                    }
                }
            }
        });





    }

    private void updateResultText() {

        if (!isEqualButtonPressed && inputLine.length() > 3) {
            Double res = evaluateExpression(inputLine.toString().trim());
            if (res == Math.floor(res)) {

                result.setText(String.valueOf(res.intValue()));
            } else {

                result.setText(String.valueOf(res));
            }
        }
    }

    private Double evaluateExpression(String expression) {
        String[] tokens = expression.split("\\s+");
        Double result = null;
        char operator = '+';

        for (String token : tokens) {
            if (token.matches("[+\\-×÷]")) {
                operator = token.charAt(0);
            } else {
                Double operand = Double.parseDouble(token);
                if (result == null) {
                    result = operand;
                } else {
                    switch (operator) {
                        case '+':
                            result += operand;
                            break;
                        case '-':
                            result -= operand;
                            break;
                        case '×':
                            result *= operand;
                            break;
                        case '÷':
                            if (operand == 0) {
                                throw new ArithmeticException("Division by zero error!");
                            }
                            result /= operand;
                            break;
                    }
                }
            }
        }

        return result;
    }

    private boolean endsWithOperator(StringBuilder inputLine) {
        return inputLine.length() >= 3 && isOperator(inputLine.substring(inputLine.length() - 3));
    }


    private boolean endsWithDecimal(StringBuilder inputLine) {
        return inputLine.length() > 0 && inputLine.charAt(inputLine.length() - 1) == '.';
    }


    private boolean isOperator(String str) {
        return str.equals(" + ") || str.equals(" - ") || str.equals(" × ") || str.equals(" ÷ ");
    }


}