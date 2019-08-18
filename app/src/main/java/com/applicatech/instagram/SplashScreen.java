package com.applicatech.instagram;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.ParseUser;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ParseUser currentUser = ParseUser.getCurrentUser();
                if (currentUser != null) {
                    // do stuff with the user
                    Intent i = new Intent(SplashScreen.this, MainActivity.class);
                    SplashScreen.this.startActivity(i);
                    SplashScreen.this.finish();
                } else {
                    // show the signup or login screen
                    Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                    SplashScreen.this.startActivity(i);
                    SplashScreen.this.finish();
                }


            }
        }, 3000);
    }
}
