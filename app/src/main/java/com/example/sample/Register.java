package com.example.sample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText memail,mphone,mpassword,f_name,l_name,r_pswd;
    Button register;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        memail= (EditText) findViewById(R.id.email);
        mphone= (EditText) findViewById(R.id.phone);
        mpassword= (EditText) findViewById(R.id.password);
        f_name= (EditText) findViewById(R.id.f_name);
        l_name= (EditText) findViewById(R.id.l_name);
        r_pswd= (EditText) findViewById(R.id.repswd);
        register= (Button) findViewById(R.id.submit_registr);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() !=null){
            startActivity(new Intent(getApplicationContext(),Mainmenu.class));
            finish();
        }

        register.setOnClickListener(new View.OnClickListener() {
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

                // registering user to firebase

                mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(Register.this, "Registere Sucessfully", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                            finish();
                        }
                        else {
                            Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });


    }
}