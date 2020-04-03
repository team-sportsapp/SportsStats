package com.example.sportsstats;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {

    EditText mpassword,memail;
    Button regbtn;
    FirebaseAuth fAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mpassword = (EditText)findViewById(R.id.etPassword);
        memail = (EditText)findViewById(R.id.etUserName);
        regbtn = findViewById(R.id.regBtn);

        fAuth = FirebaseAuth.getInstance();//gets the current database from firebase
        if(fAuth.getCurrentUser()!= null) {

            startActivity(new Intent(getApplicationContext(),MainActivity.class));
            finish();
        }
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
                            Toast.makeText(Register.this, "User Created.", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(Register.this, "Error !"+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }

                    }
                });//passes email and password to database.

            }
        });
    }
}
/* void OnReg(View view){
    String str_username = username.getText().toString();
    String str_password = password.getText().toString();
    String str_email = email.getText().toString();
    String type = "register";
    BackgroundWorker backgroundWorker = new BackgroundWorker(this);
    backgroundWorker.execute(type, str_username, str_password,str_email);

    startActivity(new Intent(this,MainActivity.class));

}
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        //FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

}*/
