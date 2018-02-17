package com.example.maruthiraja.smartshopping;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
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

public class CustomerLog extends Activity {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText username;
    private EditText password;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerlogin);
        username = (EditText)findViewById(R.id.editUsname);
        password = (EditText)findViewById(R.id.editPassId);
        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(CustomerLog.this,customerfistpage.class));
                    finish();
                }
            }
        };
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void callSignup(View view){
        startActivity(new Intent(CustomerLog.this, CustomerSignup.class));
        finish();
    }

    public void signin(View view)
    {
        String uname = username.getText().toString();
        String pass = password.getText().toString();

        if (TextUtils.isEmpty(uname) || TextUtils.isEmpty(pass))
        {
            Toast.makeText(this, "Fields are Empty.", Toast.LENGTH_SHORT).show();
        }else {
            progressDialog.setMessage("Signing In");
            progressDialog.show();
           // Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            mAuth.signInWithEmailAndPassword(uname, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (!task.isSuccessful()) {
                        progressDialog.dismiss();
                        Toast.makeText(CustomerLog.this, "Incorrect User Id or Password..!!!", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        progressDialog.dismiss();
                    }
                }
            });
        }
    }
}
