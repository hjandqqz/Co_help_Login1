package com.example.co_help_login.activity.user;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;
import com.example.co_help_login.R;

public class IntroductionActivity extends AppCompatActivity {

    ImageView logo,appName,splashImg;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);

        logo = findViewById(R.id.iv_logo);
        appName = findViewById(R.id.iv_app_name);
        splashImg = findViewById(R.id.iv_image);
        lottieAnimationView = findViewById(R.id.lottie_hamburger);

        splashImg.animate().translationY(-2600).setDuration(1000).setStartDelay(4000);
        appName.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(1800).setDuration(1000).setStartDelay(4000);
        lottieAnimationView.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivity(intent);
    }
}