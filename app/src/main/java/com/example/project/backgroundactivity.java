package com.example.project;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class backgroundactivity extends AppCompatActivity {
Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.background);

        timer = new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                Intent intent = new Intent(backgroundactivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },7000);
    }
}

