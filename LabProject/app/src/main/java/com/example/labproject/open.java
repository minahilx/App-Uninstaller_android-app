package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class open extends AppCompatActivity {
ImageView img;
TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open);
        img=findViewById(R.id.myImage);
        text=findViewById(R.id.myText);
        img.setImageResource(getIntent().getIntExtra("logo", 0)); //IF IMAGE IS INT
        text.setText(getIntent().getStringExtra("name"));

    }
}