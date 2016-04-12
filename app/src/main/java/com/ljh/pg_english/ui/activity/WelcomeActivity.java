package com.ljh.pg_english.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.ljh.pg_english.R;

import java.util.Timer;
import java.util.TimerTask;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        //通过一个时间控制函数Timer,实现一个活动到另外一个活动的跳转,从而实现欢迎界面
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                finish();
            }
        },2000);//停留时间为2秒
    }
}
