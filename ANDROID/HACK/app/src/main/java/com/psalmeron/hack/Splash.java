package com.psalmeron.hack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.psalmeron.hack.ui.Login;

public class Splash extends AppCompatActivity {
    private int SPLASH_TIME = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(SPLASH_TIME);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {

                    Intent i = new Intent(Splash.this, Login.class);
                    startActivity(i);
                    Splash.this.finish();
                }
            }
        };
        timer.start();


    }

}
