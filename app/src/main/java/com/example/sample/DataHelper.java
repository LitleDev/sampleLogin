package com.example.sample;

import android.widget.EditText;

public class DataHelper {
    String fname,lname,email,messsage;

    public DataHelper(EditText fname, EditText lname, EditText email, EditText messsage) {

    }

    public DataHelper(String fname, String lname, String email, String phone, String messasge) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.messsage = messasge;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getMessasge() {
        return messsage;
    }

    public void setMessasge(String messasge) {
        this.messsage = messasge;
    }
}
