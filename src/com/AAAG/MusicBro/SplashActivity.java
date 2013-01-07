package com.AAAG.MusicBro;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.content.Intent;


public class SplashActivity extends Activity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);
    int delay = 2000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        }, delay);
    }

}
