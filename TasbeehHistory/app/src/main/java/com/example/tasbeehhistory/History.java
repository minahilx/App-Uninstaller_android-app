package com.example.tasbeehhistory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class History extends AppCompatActivity {
    ListView list;
    List<String>  separated = new ArrayList<>();

    List<String>  array = new ArrayList<>();
    String count;
    int inc=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.customToolBar);
        setSupportActionBar(toolbar);
        list = (ListView) findViewById(R.id.listView);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        SharedPref pref = new SharedPref();

        count = pref.getCount(History.this);
       // separated.count.split(";"));
        separated= new ArrayList<>(Arrays.asList(count.split(";")));

        for(int i=0;i<separated.size();i++)
        {
            inc++;

            Log.d("MyApp","item " +inc+ separated.get(i));
            array.add(i, "Count " + inc + ") " + separated.get(i));
        }


   ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, array);
   list.setAdapter(adapter);






    }


}