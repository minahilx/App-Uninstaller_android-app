package com.example.labproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;

public class Animation extends AppCompatActivity {
    private LottieAnimationView animationView;
   CardView btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //hides the action bar
        setContentView(R.layout.activity_animation);
        animationView = (LottieAnimationView) findViewById(R.id.animation_view);
        animationView.playAnimation();
        btn= findViewById(R.id.animation_btn);
    }
    public void start_btn(View v)
    {
        Intent obj = new Intent(Animation.this, TermsCondition.class);
        startActivity(obj);
        Log.d("myApp", "Hello animation");

    }
}