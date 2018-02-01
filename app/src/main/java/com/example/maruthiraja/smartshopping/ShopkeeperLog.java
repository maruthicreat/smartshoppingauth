package com.example.maruthiraja.smartshopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;


public class ShopkeeperLog extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopkeeperloginpage);
    }

    public void testpass(View v){
        EditText useredit = (EditText) findViewById(R.id.usertext);
        EditText passedit = (EditText) findViewById(R.id.passtext);
        String usertext = String.valueOf(useredit.getText());
        String passtext = String.valueOf(passedit.getText());
        System.out.println("user :"+usertext+" passtext :" + passtext);
        if(usertext.equals(passtext))
        {
            System.out.println("success");
        }
    }

    public void callSignup(View view){
        startActivity(new Intent(ShopkeeperLog.this, ShopkeeperSignup.class));
    }
}
