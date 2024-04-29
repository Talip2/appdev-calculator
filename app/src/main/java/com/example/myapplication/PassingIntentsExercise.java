package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class PassingIntentsExercise extends AppCompatActivity {

    Button submit;
    Button clear;

    Button retMain;
    RadioButton male;
    RadioButton female;
    RadioButton others;
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
        setContentView(R.layout.activity_passing_intents_exercise);

        submit = (Button) findViewById(R.id.btnIntentSubmit);
        clear = (Button) findViewById(R.id.btnIntentClear);
        male = (RadioButton) findViewById(R.id.radioMale);
        female = (RadioButton) findViewById(R.id.radioFemale);
        others = (RadioButton) findViewById(R.id.radioOthers);
        fname = (EditText) findViewById(R.id.txtFname);
        lname = (EditText) findViewById(R.id.txtLname);
        phoneNum = (EditText) findViewById(R.id.txtPhoneNumber);
        emailAdd = (EditText) findViewById(R.id.txtEmailAdd);
        homeAdd = (EditText) findViewById(R.id.txtHomeAdd);
        GSISpin = (EditText) findViewById(R.id.txtGSIS);
        passportNum = (EditText) findViewById(R.id.txtPassport);
        licenseNum = (EditText) findViewById(R.id.txtLicenseNum);
        bankNum = (EditText) findViewById(R.id.txtBankAcc);
        bDate = (EditText) findViewById(R.id.txtBirthDate);
        retMain = (Button) findViewById(R.id.btnReturnMain);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstName = fname.getText().toString();
                String lastName = lname.getText().toString();
                String gender;

                if(male.isChecked()){
                    gender = "Male";
                } else if (female.isChecked()) {
                    gender = "Female";
                } else if (others.isChecked()) {
                    gender = "Others";
                }else{
                    gender = "Unknown";
                }

                String bday = bDate.getText().toString();
                String phone = phoneNum.getText().toString();
                String email = emailAdd.getText().toString();
                String home = homeAdd.getText().toString();
                String gsis = GSISpin.getText().toString();
                String passport = passportNum.getText().toString();
                String license = licenseNum.getText().toString();
                String bank = bankNum.getText().toString();

                Intent intent = new Intent(PassingIntentsExercise.this, PassingIntentsExercise2.class);

                intent.putExtra("fname_key", firstName);
                intent.putExtra("lname_key", lastName);
                intent.putExtra("gender_key", gender);
                intent.putExtra("bdate_key", bday);
                intent.putExtra("phone_key", phone);
                intent.putExtra("email_key", email);
                intent.putExtra("home_key", home);
                intent.putExtra("gsis_key", gsis);
                intent.putExtra("passport_key", passport);
                intent.putExtra("license_key", license);
                intent.putExtra("bank_key", bank);

                startActivity(intent);

            }
        });


        retMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassingIntentsExercise.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}