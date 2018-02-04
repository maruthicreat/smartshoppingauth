package com.example.maruthiraja.smartshopping;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ShopkeeperSignup extends Activity{

    DatabaseReference mDatabase;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText userId,emailId,password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopsignuppage);
        userId = (EditText)findViewById(R.id.CUserId);
        emailId = (EditText) findViewById(R.id.CEmail);
        password = (EditText) findViewById(R.id.CPass);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("ShopkeeperSignup");
    }

    public void storeUserData(View view)
    {
        final String userid = userId.getText().toString().trim();
        final String emailid = emailId.getText().toString().trim();
        final String passwordid = password.getText().toString().trim();
        if(TextUtils.isEmpty(userId.getText()) && TextUtils.isEmpty(userId.getText()) && TextUtils.isEmpty(userId.getText()))
        {
            Toast.makeText(this, "Pls fill the text fields...!!!", Toast.LENGTH_SHORT).show();
        }
        else {
            progressDialog.setMessage("Signing Up...!!!");
            progressDialog.show();
            firebaseAuth.createUserWithEmailAndPassword(userid,passwordid).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        String u_id = firebaseAuth.getCurrentUser().getUid();
                        DatabaseReference c_uid = mDatabase.child(u_id);
                        c_uid.child("user_id").setValue(userid);
                        c_uid.child("mail_id").setValue(emailid);
                        c_uid.child("password").setValue(passwordid);
                        progressDialog.dismiss();
                        Toast.makeText(ShopkeeperSignup.this, "You are Successfully Signed up...!!!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        progressDialog.dismiss();
                        Toast.makeText(ShopkeeperSignup.this, "You are Already Signed up...!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

}
