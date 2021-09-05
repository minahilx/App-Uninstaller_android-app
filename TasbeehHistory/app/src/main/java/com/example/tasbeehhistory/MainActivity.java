package com.example.tasbeehhistory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView counterTxt; //declaring TextView Variable
    //private TextView result; //declaring TextView Variable

    private Button countBtn; //declaring Button Variable
    private Button resetBtn; //declaring Button Variable
    private int counter;
    String var;
    SharedPref obj = new SharedPref();



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counterTxt = findViewById(R.id.counterTxt); //initializing TextView variable
        countBtn = findViewById(R.id.count_btn); //initializing count button variable
        resetBtn = findViewById(R.id.reset_btn); //initializing reset button variable
        var="";


        Toolbar toolbar = findViewById(R.id.customToolBar);
        setSupportActionBar(toolbar);


        countBtn.setOnClickListener(new View.OnClickListener() //on clicking count button perform the below mentioned action
        {
            @Override
            public void onClick(View v) {

                counter++; //incrementing the counter when this(count) button gets clicked

                counterTxt.setText(counter + "");
                // counterTxt.setText(counter + ""); //updating the text of counterTxt variable, displaying the current value stored in counter variables on the TextView

            }
        });

        resetBtn.setOnClickListener(new View.OnClickListener() //on clicking reset button perform the below mentioned action

        {
            @Override
            public void onClick(View v) {

              //  historyArr[historyCount] = "" + counter + ";"; //store counters value in historyArr every time reset button gets clicked
                if(var.isEmpty())
                {
                    var= ""+counter;
                }
                else
                {
                    var= var + ';' + counter;

                }


             if (obj.setCount(MainActivity.this, var)) ;
             {
                   Toast.makeText(MainActivity.this, "count saved!", Toast.LENGTH_SHORT).show();
                }
               // historyCount++; //It is basically used as index for storing counters values in historyArr..
                // each time we store val in array we increment this variable so that next time when the value will be stored it'll have a new index in array
                counter = 0; //resetting the counter back to when this(reset) button gets clicked
                counterTxt.setText(counter + ""); //updating the text of counterTxt variable,  displaying the current value stored in counter variables on the TextView

            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.main_activity_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.historyBtn:
                Intent obj = new Intent(MainActivity.this, History.class);
                startActivity(obj);
                return true;


            default: return true;
        }
    }

}