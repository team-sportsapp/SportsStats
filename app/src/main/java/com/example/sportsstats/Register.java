package com.example.sportsstats;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {
EditText username, password,email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText)findViewById(R.id.et_username);
        password = (EditText)findViewById(R.id.et_password);
        email = (EditText)findViewById(R.id.et_email);
    }
public void onReg(View view){

    String str_username = username.getText().toString();
    String str_password = password.getText().toString();
    String str_email = email.getText().toString();
    String type = "register";
    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
    backgroundWorker.execute(type, str_username, str_password,str_email);

}

}
