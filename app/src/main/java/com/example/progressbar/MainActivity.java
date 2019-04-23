package com.example.progressbar;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    ProgressBar myProgressBar;
    Handler myHandler;
    Runnable myRunnable;
    Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
  //don't forget to declare the variables in this code

    myProgressBar = (ProgressBar) findViewById(R.id.progressBar);
          myProgressBar.setVisibility(View.VISIBLE);

          myHandler = new Handler();
          myRunnable = new Runnable() {
              @Override
              public void run() {
                  myTimer.cancel();
                  myProgressBar.setVisibility(View.GONE);
              }
          };
          myTimer = new Timer();

          myTimer.schedule(new TimerTask() {
              @Override
              public void run() {
                  myHandler.post(myRunnable);
              }
          }, 8000, 1000);

    }
}
