package com.example.sportsstats;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    EditText mpassword,memail;
    Button regbtn, loginBtn;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mpassword = (EditText)findViewById(R.id.etPassword);
        memail = (EditText)findViewById(R.id.etUserName);
        regbtn = findViewById(R.id.regBtn);
        loginBtn = findViewById(R.id.loginBtn);
        fAuth = FirebaseAuth.getInstance();//gets the current database from firebase
        //EmailEt = (EditText)findViewById(R.id.et_email);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password is Required.");
                    return;
                }
                if(password.length()<6){
                    mpassword.setError("Password Length Must Be Greater Then 6.");
                    return;
                }
                fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });//passes email and password to database.

            }
        });
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();
                if(TextUtils.isEmpty(email)){
                    memail.setError("Email is Required.");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mpassword.setError("Password is Required.");
                    return;
                }
                if(password.length()<6){
                    mpassword.setError("Password Length Must Be Greater Then 6.");
                    return;
                }

                //authenticate login
                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Succesful!.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MatchesActivity.class));
                        }
                        else{
                            Toast.makeText(MainActivity.this, "User Email or Password Not Recognized !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });


            }
        });

    }

}