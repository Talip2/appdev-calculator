package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class OpenMaps extends AppCompatActivity {
    ImageButton map1;
    ImageButton map2;
    ImageButton map3;
    ImageButton map4;
    ImageButton map5;

    ConstraintLayout layoutBG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_maps);

        layoutBG = (ConstraintLayout) findViewById(R.id.cnstrntMapBG);

        map1 = (ImageButton) findViewById(R.id.imageButton1);
        map2 = (ImageButton) findViewById(R.id.imageButton2);
        map3 = (ImageButton) findViewById(R.id.imageButton3);
        map4 = (ImageButton) findViewById(R.id.imageButton4);
        map5 = (ImageButton) findViewById(R.id.imageButton5);

        map1.setOnClickListener(gotoMap1);
        map2.setOnClickListener(gotoMap2);
        map3.setOnClickListener(gotoMap3);
        map4.setOnClickListener(gotoMap4);
        map5.setOnClickListener(gotoMap5);


    }

    View.OnClickListener gotoMap1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layoutBG.setBackgroundResource(R.drawable.a);
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 8.46965241440557, 123.77594866199594"));
            startActivity(intent1);
        }
    };

    View.OnClickListener gotoMap2 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layoutBG.setBackgroundResource(R.drawable.b);
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 8.30787381332029, 123.61533091366357"));
            startActivity(intent1);
        }
    };

    View.OnClickListener gotoMap3 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layoutBG.setBackgroundResource(R.drawable.c);
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 14.58183878541546, 120.97702703872903"));
            startActivity(intent1);
        }
    };

    View.OnClickListener gotoMap4 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layoutBG.setBackgroundResource(R.drawable.d);
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 10.310870085447128, 124.01519855549742"));
            startActivity(intent1);
        }
    };

    View.OnClickListener gotoMap5 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            layoutBG.setBackgroundResource(R.drawable.e);
            Intent intent1 = new Intent(Intent.ACTION_VIEW, Uri.parse("geo: 34.0418356172892, -118.26695689210923"));
            startActivity(intent1);
        }
    };
}