package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class ButtonPrelim extends AppCompatActivity {
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    RelativeLayout relativeLayout;
    boolean clicked = false;
    boolean clicked1 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_prelim);

        btn1 = (Button) findViewById(R.id.btnAct1);
        btn1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent intent1 = new Intent(ButtonPrelim.this, MainActivity.class);
                startActivity(intent1);

            }
        });

        btn2 = (Button) findViewById(R.id.btnAct2);
        btn2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                btn2.setAlpha(0);


            }
        });

        btn3 = (Button) findViewById(R.id.btnAct3);
        btn3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Toast.makeText(ButtonPrelim.this, "Hello Sir", Toast.LENGTH_SHORT).show();


            }
        });




        btn5 = (Button) findViewById(R.id.btnAct5);
        btn5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                    if(clicked){
                        btn5.setBackgroundColor(getResources().getColor(R.color.purple_500));
                        clicked = false;
                        return;
                    }
                    btn5.setBackgroundColor(getResources().getColor(R.color.teal_200));
                    clicked = true;

            }
        });





        btn6 = (Button) findViewById(R.id.btnAct6);
        relativeLayout = (RelativeLayout) findViewById(R.id.rlButtonExercise);
        btn6.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                if(clicked1){
                    relativeLayout.setBackgroundColor(getResources().getColor(R.color.white));
                    clicked1 = false;
                    return;
                }
                relativeLayout.setBackgroundColor(getResources().getColor(R.color.teal_200));
                clicked1 = true;
            }
        });
    }
}