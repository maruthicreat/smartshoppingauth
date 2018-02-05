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


public class CustomerSignup extends Activity{

    DatabaseReference mDatabase;
    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;
    EditText repass,emailId,password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cussignuppage);
        repass = (EditText)findViewById(R.id.Cretypepass);
        emailId = (EditText) findViewById(R.id.CEmail);
        password = (EditText) findViewById(R.id.CPass);
        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference("CustomerSignup");
    }

    public void storeUserData(View view)
    {

            final String rep = repass.getText().toString().trim();
            final String emailid = emailId.getText().toString().trim();
            final String passwordid = password.getText().toString().trim();
            if (TextUtils.isEmpty(rep) && TextUtils.isEmpty(emailid) && TextUtils.isEmpty(passwordid)){
                Toast.makeText(this, "Pls fill the text fields...!!!", Toast.LENGTH_SHORT).show();
            }
            else {
                if (rep.equals(passwordid))
                {
                    progressDialog.setMessage("Signing Up...!!!");
                    progressDialog.show();
                    firebaseAuth.createUserWithEmailAndPassword(emailid, passwordid).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                String u_id = firebaseAuth.getCurrentUser().getUid();
                                DatabaseReference c_uid = mDatabase.child(u_id);
                                c_uid.child("user_id").setValue("1");
                                c_uid.child("mail_id").setValue(emailid);
                                c_uid.child("password").setValue(passwordid);
                                progressDialog.dismiss();
                                Toast.makeText(CustomerSignup.this, "You are Successfully Signed up...!!!", Toast.LENGTH_SHORT).show();
                            } else {
                                progressDialog.dismiss();
                                Toast.makeText(CustomerSignup.this, "You are Already Signed up...!!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(this, "Pls Check the Re-Type Password..!!!", Toast.LENGTH_SHORT).show();
                }
            }
    }
}
