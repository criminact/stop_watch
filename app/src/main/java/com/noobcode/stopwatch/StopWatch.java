package com.noobcode.stopwatch;

import android.os.Handler;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class StopWatch {

    Timer timer;
    long pausedTime = 0;
    TimerTask timerTask;
    long time = 0;
    TextView text;
    Handler mTimerHandler = new Handler();

    public StopWatch(TextView text) {
        this.text = text;
    }

    public void startTimer(){

        timer = new Timer();

        long pausedFor = pausedTime - time;
        time = System.currentTimeMillis() - pausedFor;

        timerTask = new TimerTask() {
            @Override
            public void run() {
                start();
            }
        };

        timer.schedule(timerTask, 1, 1);
    }

    private void start(){
        mTimerHandler.post(new Runnable() {
            @Override
            public void run() {
                String seconds = String.valueOf((System.currentTimeMillis() - time)/1000);
                String milliSeconds = String.valueOf(System.currentTimeMillis() - time).substring(seconds.length());
                text.setText(seconds + "s " + milliSeconds + "ms");
            }
        });
    }

    public void resetTimer(){
        timer.cancel();
        timerTask.cancel();
        time = 0;
        pausedTime = 0;
        text.setText("0s 0");
    }

    public void stopTimer(){
            timer.cancel();
            pausedTime = System.currentTimeMillis();
    }

}
