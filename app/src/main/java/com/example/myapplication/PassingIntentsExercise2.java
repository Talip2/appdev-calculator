package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PassingIntentsExercise2 extends AppCompatActivity {

    Button Breturn;

   EditText gender;
    EditText fname;
    EditText lname;
    EditText bDate;
    EditText phoneNum;
    EditText emailAdd;
    EditText homeAdd;
    EditText GSISpin;
    EditText passportNum;
    EditText licenseNum;
    EditText bankNum;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passing_intents_exercise2);

        Breturn = (Button) findViewById(R.id.btnIntentReturn);
        gender = (EditText) findViewById(R.id.txtGender);
        fname = (EditText) findViewById(R.id.txtFname);
        lname = (EditText) findViewById(R.id.txtLname);
        phoneNum = (EditText) findViewById(R.id.txtPhoneNumber);
        emailAdd = (EditText) findViewById(R.id.txtEmailAdd1);
        homeAdd = (EditText) findViewById(R.id.txtHomeAdd);
        GSISpin = (EditText) findViewById(R.id.txtGSIS);
        passportNum = (EditText) findViewById(R.id.txtPassport);
        licenseNum = (EditText) findViewById(R.id.txtLicenseNum);
        bankNum = (EditText) findViewById(R.id.txtBankAcc);
        bDate = (EditText) findViewById(R.id.txtBirthDate);

        Intent intent = getIntent();


        String firstName = intent.getStringExtra("fname_key");
        String lastName = intent.getStringExtra("lname_key");
        String genderString = intent.getStringExtra("gender_key");
        String bday = intent.getStringExtra("bdate_key");
        String phone = intent.getStringExtra("phone_key");
        String email = intent.getStringExtra("email_key");
        String home = intent.getStringExtra("home_key");
        String gsis = intent.getStringExtra("gsis_key");
        String passport = intent.getStringExtra("passport_key");
        String license = intent.getStringExtra("license_key");
        String bank =intent.getStringExtra("bank_key");

        fname.setText(firstName);
        lname.setText(lastName);
        gender.setText(genderString);
        bDate.setText(bday);
        phoneNum.setText(phone);
        emailAdd.setText(email);
        homeAdd.setText(home);
        GSISpin.setText(gsis);
        passportNum.setText(passport);
        licenseNum.setText(license);
        bankNum.setText(bank);

        Breturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(PassingIntentsExercise2.this, PassingIntentsExercise.class);
                startActivity(intent1);
            }
        });

    }


}