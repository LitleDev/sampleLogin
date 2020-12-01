package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText mpassword,memail;
    Button mlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        mpassword = (EditText) findViewById(R.id.password);
        memail = (EditText) findViewById(R.id.email);
        mlogin = (Button) findViewById(R.id.login_btn);

        mlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = memail.getText().toString().trim();
                String password = mpassword.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
                    memail.setError("Email Required");
                    return;
                }
                if (TextUtils.isEmpty(password)){
                    mpassword.setError("Password Required");
                    return;
                }
                if (password.length()<6) {
                    mpassword.setError("minimum 6 character required");
                }

                // authenticating user
                mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "LogedIn Sucessfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),Mainmenu.class));
                        }
                        else {
                            Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    public void register (View v) {
        Intent intent = new Intent(this,Register.class);
        startActivity(intent);
    }




}