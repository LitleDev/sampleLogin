package com.example.sample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Contact_Us_Form extends AppCompatActivity {
    FirebaseAuth mAuth;

    EditText fname,lname,email,messsage;
    Button submitfedback;
    FirebaseDatabase rootnode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact__us__form);
        mAuth = FirebaseAuth.getInstance();

        fname = (EditText)findViewById(R.id.f_namef);
        lname = (EditText)findViewById(R.id.l_namef);
        email = (EditText)findViewById(R.id.emailf);
        messsage = (EditText)findViewById(R.id.messagef);
        submitfedback = (Button) findViewById(R.id.contactusSubmit);

        submitfedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("users");

                String firstname = fname.getText().toString();
                String lastname = lname.getText().toString();
                String emailadd = email.getText().toString();
                String usermsg = messsage.getText().toString();

                reference.setValue("First Data Storage");
                DataHelper helperClass= new DataHelper(fname,lname,email,messsage);
                reference.setValue(helperClass);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if (mAuth.getCurrentUser() !=null) {
            startActivity(new Intent(getApplicationContext(), Mainmenu.class));
            finish();
        }
            else {
                super.onBackPressed();
            }

    }
}