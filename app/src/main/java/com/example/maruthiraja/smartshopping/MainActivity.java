package com.example.maruthiraja.smartshopping;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customerLogin(View v)
    {
        startActivity(new Intent(MainActivity.this, CustomerLog.class));
        System.out.println("hai");
    }

    public void shopKeeperLogin(View v)
    {
        startActivity(new Intent(MainActivity.this, ShopkeeperLog.class));
        System.out.println("hai");
    }

}
