package com.example.shoo.gptrial2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import libsvm.svm;

public class SignUpActivity extends AppCompatActivity {

    EditText mail;
    EditText password;
    EditText age;
    EditText phone;
    EditText name;
    EditText eContact1;
    EditText eContact2;

    RadioButton female;
    RadioButton male;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //male.setChecked(true);

        mail = (EditText) findViewById(R.id.txtEmail);
        password = (EditText) findViewById(R.id.txtPassword);
        name = (EditText) findViewById(R.id.txtNamw);
        age = (EditText) findViewById(R.id.txtAge);
        phone = (EditText) findViewById(R.id.txtPhone);
        eContact1 = (EditText) findViewById(R.id.txtEcontact1);
        eContact2 = (EditText) findViewById(R.id.txtEcontact2);
        female = (RadioButton) findViewById(R.id.btnFemal);
        male = (RadioButton) findViewById(R.id.btnMale);

        Button signUp= (Button)findViewById(R.id.btnCreat);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String gender;
                if(female.isChecked())
                    gender="f";
                else
                    gender="m";

                SharedPreferences prefs = getSharedPreferences("prefs", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = prefs.edit();

                editor.putString("mail", mail.getText().toString());
                editor.putString("password", password.getText().toString());
                editor.putString("age", age.getText().toString());
                editor.putString("name", name.getText().toString());
                editor.putString("econtact1", eContact1.getText().toString());
                editor.putString("econtact2", eContact2.getText().toString());
                editor.putString("phone", phone.getText().toString());
                editor.putString("gender", gender);

                editor.commit();

                Toast.makeText(SignUpActivity.this, "Saved", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),SignINActivity.class);
                startActivity(i);

            }
        });


    }

    public void SignUp(View view) {

        Toast.makeText(this, "e7na filButton", Toast.LENGTH_SHORT).show();
    }

}

