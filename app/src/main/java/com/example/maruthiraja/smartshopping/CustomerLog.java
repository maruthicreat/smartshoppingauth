package com.example.maruthiraja.smartshopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class CustomerLog extends Activity {

    final FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference ref;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customerlogin);
        ref = database.getReference("");
    }

    public void callSignup(View view){
        startActivity(new Intent(CustomerLog.this, CustomerSignup.class));
    }

    public void signin(View view)
    {
        Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                USignUp post = dataSnapshot.getValue(USignUp.class);
                System.out.println(post);
                System.out.println("im in");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }
}
