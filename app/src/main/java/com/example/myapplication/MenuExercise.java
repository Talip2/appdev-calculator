package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.view.animation.TranslateAnimation;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MenuExercise extends AppCompatActivity {

    Button btnChanger;

    LinearLayout lnrLayoutChngr;
    int randomColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_exercise);

        btnChanger = findViewById(R.id.btnTransformingButton);
        lnrLayoutChngr = findViewById(R.id.lnrLayoutBtnChanger);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_menuexercise,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.mItemchange){
            Toast.makeText(this, "Edit object is clicked", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.mItemReset) {
            Toast.makeText(this, "Reset object is clicked", Toast.LENGTH_SHORT).show();

            int widthInDp = 300;
            int heightInDp = 300;
            int cornerRadiusInDp = 500;

            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(cornerRadiusInDp);

            btnChanger.setBackground(gradientDrawable);

            btnChanger.setWidth(widthInDp);
            btnChanger.setHeight(heightInDp);
            lnrLayoutChngr.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);

        } else if (item.getItemId() == R.id.mItemExit) {
            finish();
        } else if (item.getItemId() == R.id.mItemRandColor) {

                Random random = new Random();
                int r = (int) (random.nextDouble() * 128 + 128);
                int g = (int) (random.nextDouble() * 128 + 128);
                int b = (int) (random.nextDouble() * 128 + 128);
                randomColor = Color.rgb(r, g, b);

            btnChanger.setBackgroundColor(randomColor);

        } else if (item.getItemId() == R.id.mItemChangePos) {
            Random random = new Random();
            int x = random.nextInt(100);
            int y = random.nextInt(100);
            int gravityFlags = 0;

            if (x < 50) {
                gravityFlags |= Gravity.LEFT;
            } else {
                gravityFlags |= Gravity.RIGHT;
            }

            if (y < 50) {
                gravityFlags |= Gravity.TOP;
            } else {
                gravityFlags |= Gravity.BOTTOM;
            }

            // Set the gravity of the LinearLayout
            lnrLayoutChngr.setGravity(gravityFlags);
        }

        else if (item.getItemId() == R.id.mItemCntryBall) {
            btnChanger.setBackgroundResource(R.drawable.countryball);

        } else if (item.getItemId() == R.id.mItemBoxy) {
            btnChanger.setHeight(300);
            btnChanger.setWidth(300);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(0);
            btnChanger.setBackground(gradientDrawable);
            btnChanger.setBackgroundColor(randomColor);

        }else if (item.getItemId() == R.id.mItemMoveLikeDvD){
            startBouncingAnimation();
        }



        return true;
    }


    private void startBouncingAnimation() {
        float startX = 0;
        float startY = 0;

        int layoutWidth = lnrLayoutChngr.getWidth();
        int layoutHeight = lnrLayoutChngr.getHeight();
        int btnWidth = btnChanger.getWidth();
        int btnHeight = btnChanger.getHeight();
        int maxX = layoutWidth - btnWidth;
        int maxY = layoutHeight - btnHeight;

        TranslateAnimation animation = new TranslateAnimation(startX, maxX, startY, maxY);
        animation.setDuration(3000);
        animation.setFillAfter(true);
        animation.setRepeatCount(Animation.INFINITE);
        animation.setRepeatMode(Animation.REVERSE);
        btnChanger.startAnimation(animation);
    }





}