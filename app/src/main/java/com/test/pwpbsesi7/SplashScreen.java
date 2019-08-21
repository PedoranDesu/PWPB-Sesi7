package com.test.pwpbsesi7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    ProgressBar mCircle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mCircle = findViewById(R.id.prog_splash);
        mCircle.getIndeterminateDrawable().setColorFilter(Color.BLUE,android.graphics.PorterDuff.Mode.MULTIPLY);

        new Thread(new Runnable() {
            @Override
            public void run() {
                loadingApp();
                toHome();
                finish();
            }
        }).start();
    }

    private void loadingApp(){
        for (int progress=0; progress<100; progress+=10) {
            try {
                Thread.sleep(200);
                mCircle.setProgress(progress);
            } catch (Exception e) {
                e.printStackTrace();
                Log.d("ERROR",e.getMessage());
            }
        }
    }

    private void toHome(){
        Intent homie = new Intent(SplashScreen.this,MainActivity.class);
        startActivity(homie);
    }
}
