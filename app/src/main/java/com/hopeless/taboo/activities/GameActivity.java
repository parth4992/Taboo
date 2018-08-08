package com.hopeless.taboo.activities;

import android.os.CountDownTimer;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hopeless.taboo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends AppCompatActivity {

    CountDownTimer timer;
    @BindView(R.id.timer) TextView timerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ButterKnife.bind(this);
        timer = new CountDownTimer(31000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String x = (millisUntilFinished/1000) + "";
                timerView.setText(x);
            }

            @Override
            public void onFinish() {

            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(timer != null){
            timer.start();
        }
    }

}
