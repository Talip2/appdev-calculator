package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Stack;

public class CalculatorExercise extends AppCompatActivity {


    private StringBuilder inputLine;
    private String inputEquDummy = null;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        inputLine = new StringBuilder();
        setContentView(R.layout.activity_calculator_exercise);
        input = (EditText) findViewById(R.id.input);
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
            }

        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("1");
                input.setText(inputLine);
            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("2");
                input.setText(inputLine);
            }
        });

        btnThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("3");
                input.setText(inputLine);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("4");
                input.setText(inputLine);
            }
        });


        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("5");
                input.setText(inputLine);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("6");
                input.setText(inputLine);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("7");
                input.setText(inputLine);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("8");
                input.setText(inputLine);
            }
        });

        btnNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("9");
                input.setText(inputLine);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("+");
                input.setText(inputLine);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("-");
                input.setText(inputLine);
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("×");
                input.setText(inputLine);
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("÷");
                input.setText(inputLine);
            }
        });

        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append("=");
                input.setText(inputLine);
                calculator = new Calculator(inputLine.toString());
                int res = calculator.Calculate();
                input.setText(Integer.toString(res));
            }
        });

        btnDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inputLine.append(".");
                input.setText(inputLine);
            }
        });
    }





}