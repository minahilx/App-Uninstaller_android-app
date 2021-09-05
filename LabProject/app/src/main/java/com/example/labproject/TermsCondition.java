package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TermsCondition extends Helper {
    Button continuePref;
    Button check;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms_condition);
      //  requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //hides the action bar
        continuePref= findViewById(R.id.continue_btn);
        check = findViewById(R.id.den_btn);
       // getSupportActionBar().setTitle("Terms and Condition");
       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    //    Log.d("myApp", "Hello terms");

        if(getPreference("already").equalsIgnoreCase("done"))
        {
            Intent ok = new Intent(this, uninstallApp.class);
            startActivity(ok);
            this.finish();

        }





    }

    public void save(View v)
    {
       setPreference("already","done");
        Toast.makeText(this, "Continue button clicked", Toast.LENGTH_SHORT).show();
        Intent ok = new Intent(this, uninstallApp.class);
        startActivity(ok);
        this.finish();
    }

    public void deny(View v)
    {
        Toast.makeText(this, "Deny button clicked", Toast.LENGTH_SHORT).show();
        Intent om = new Intent(this, uninstallApp.class);
        startActivity(om);
        this.finish();
    }
}