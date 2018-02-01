package com.example.maruthiraja.smartshopping;


public class USignUp {
    public String userId;
    public String emailId;
    public String password;

    public USignUp()
    {
    }

    public USignUp(String userId,String password,String emailId)
    {
        this.userId = userId;
        this.password = password;
        this.emailId = emailId;
    }
}
