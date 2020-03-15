package com.example.mathshoot;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN = 2000;
    Animation leftAnim,rightAnim,bottomAnim;
    ImageView hoopImage,peopleImage;
    TextView gameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Hide status bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getWindow().setBackgroundDrawableResource(R.drawable.background_white);
        setContentView(R.layout.activity_splash);

        leftAnim = AnimationUtils.loadAnimation(this,R.anim.animation_left);
        rightAnim = AnimationUtils.loadAnimation(this,R.anim.animation_right);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.animation_bottom);

        leftAnim.setDuration(1500);
        rightAnim.setDuration(1500);
        bottomAnim.setDuration(1500);

        hoopImage = findViewById(R.id.hoopImage);
        peopleImage = findViewById(R.id.peopleImage);
        gameText = findViewById(R.id.gameText);

        hoopImage.setAnimation(leftAnim);
        peopleImage.setAnimation(rightAnim);
        gameText.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(myIntent);
                finish();
            }
        },SPLASH_SCREEN);
    }
}
