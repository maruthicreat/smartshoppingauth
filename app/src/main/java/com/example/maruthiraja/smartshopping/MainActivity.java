package com.example.maruthiraja.smartshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    //private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // database = FirebaseDatabase.getInstance();
    }

    public void customerLogin(View v)
    {
        startActivity(new Intent(MainActivity.this, CustomerLog.class));
        //System.out.println("hai");

    }

    public void shopKeeperLogin(View v)
    {
        startActivity(new Intent(MainActivity.this, ShopkeeperLog.class));
        //System.out.println("hai");
    }

    /*public void addData(View view){

        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(MainActivity.this, "Oops " + databaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }*/

}
