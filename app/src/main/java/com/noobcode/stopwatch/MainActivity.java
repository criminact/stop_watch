package com.noobcode.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {

    private Button start;
    private Button reset;
    private TextView time;
    private int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initUi();
    }

    private void initUi() {
        time = (TextView) findViewById(R.id.timer);
        reset = (Button) findViewById(R.id.restart);
        start = (Button) findViewById(R.id.start);

        final StopWatch stopWatch = new StopWatch(time);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i == 1){
                    i = 0;
                    stopWatch.stopTimer();
                    reset.setClickable(true);
                }else{
                    i = 1;
                    stopWatch.startTimer();
                    reset.setClickable(false);
                }
                switchToggle();

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopWatch.resetTimer();
            }
        });
    }

    private void switchToggle() {
        if(i == 1){
            start.setText("STOP");
        }else{
            start.setText("START");
        }
    }
}
