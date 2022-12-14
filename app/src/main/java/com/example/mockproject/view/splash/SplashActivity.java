package com.example.mockproject.view.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mockproject.R;
import com.example.mockproject.view.main_activity.MainActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);

        ImageView imgLogo = findViewById(R.id.iv_logo_splash);
        TextView txtLogo = findViewById(R.id.tv_logo_splash);

        TranslateAnimation animationLeftToCenter = new TranslateAnimation(-100f, 0, 0, 0);
        animationLeftToCenter.setDuration(1500);
        TranslateAnimation animationRightToCenter = new TranslateAnimation(100f, 0, 0, 0);
        animationRightToCenter.setDuration(1500);

        imgLogo.setAnimation(animationLeftToCenter);
        txtLogo.setAnimation(animationRightToCenter);

        Runnable runnable = () -> {
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
            finish();
        };
        new Handler().postDelayed(runnable, 2500);

    }
}
