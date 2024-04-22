package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;

    Button btn5;


    Button btn6;


    Button btn7;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btnLayoutExer);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, InstagramFeed.class);
                startActivity(intent1);

            }
        });


        btn2 = (Button) findViewById(R.id.btnButtonExer);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, ButtonPrelim.class);
                startActivity(intent1);

            }
        });

        btn3 = (Button) findViewById(R.id.btnCalcuExer);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(MainActivity.this, CalculatorExercise.class);
                startActivity(intent1);

            }
        });

        btn4 = (Button) findViewById(R.id.btnConnecThree);
        btn4.setOnClickListener(ConnectThree);

        btn5 = (Button) findViewById(R.id.btnPassingIntents);
        btn5.setOnClickListener(PassingIntents);

        btn6 = (Button) findViewById(R.id.btnFragments);


        btn7 = (Button) findViewById(R.id.btnMenus);
        btn7.setOnClickListener(Menus);






    }

    View.OnClickListener ConnectThree = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent1 = new Intent(MainActivity.this, ConnectThree.class);
            startActivity(intent1);
        }
    };

    View.OnClickListener PassingIntents = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, PassingIntentsExercise.class);
            startActivity(intent);
        }
    };

    View.OnClickListener Menus = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, MenuExercise.class);
            startActivity(intent);
        }
    };
}