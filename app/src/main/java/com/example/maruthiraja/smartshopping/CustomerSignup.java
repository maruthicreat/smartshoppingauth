package com.example.maruthiraja.smartshopping;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class CustomerSignup extends Activity{

    DatabaseReference mDatabase;
    EditText userId,emailId,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cussignuppage);
        userId = (EditText)findViewById(R.id.CUserId);
        emailId = (EditText) findViewById(R.id.CEmail);
        password = (EditText) findViewById(R.id.CPass);
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        mDatabase = FirebaseDatabase.getInstance().getReference("CustomerSignup");
    }

    public void storeUserData(View view)
    {
        if(TextUtils.isEmpty(userId.getText()) && TextUtils.isEmpty(userId.getText()) && TextUtils.isEmpty(userId.getText()))
        {
            Toast.makeText(this, "Don't leave blank field", Toast.LENGTH_SHORT).show();
        }
        else {
            String userid = userId.getText().toString().trim();
            String emailid = emailId.getText().toString().trim();
            String passwordid = password.getText().toString().trim();
            String userId = mDatabase.push().getKey();
            USignUp user = new USignUp(userid,passwordid,emailid);
            mDatabase.child(userId).setValue(user);
            Toast.makeText(this, "SignUp Successfully..!!!", Toast.LENGTH_SHORT).show();
        }
    }
}
