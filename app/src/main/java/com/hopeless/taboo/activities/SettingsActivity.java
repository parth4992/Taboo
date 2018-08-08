package com.hopeless.taboo.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.hopeless.taboo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import utils.Utils;

import static utils.SharedPrefConstants.KEY_TIMER_VALUE;

public class SettingsActivity extends Activity {

    @BindView(R.id.settings_timer_view) View timerView;
    @BindView(R.id.settings_time_text) TextView timerText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.settings_timer_view)
    public void onSettingsTimerViewClick(){
//        getSharedPreferences()
        int time = Utils.getIntFromSharedPref(KEY_TIMER_VALUE);
        if(time < 120) {
            time += 15;
        } else {
            time = 30;
        }
        timerText.setText(getString(R.string.time_setting_value, time));
        Utils.saveToSharedPref(KEY_TIMER_VALUE, time);
    }
}
