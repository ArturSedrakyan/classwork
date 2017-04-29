package com.aca.app.classwork.activity;

import android.app.Activity;
import android.app.backup.SharedPreferencesBackupHelper;
import android.content.Intent;
import android.os.Handler;
import android.preference.Preference;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aca.app.classwork.R;
import com.aca.app.classwork.utils.PreferanceHelper;

public class StartupActivity extends AppCompatActivity {

    private static final int DELAY = 1000;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startup);

        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                navigate();
            }
        },DELAY);
    }
    private void navigate(){
        Class<? extends Activity> activityClass;
        if(PreferanceHelper.getInstance(this).isLoggesIn()){
            activityClass = MainActivity.class;
        }else{
            activityClass = LoginActivity.class;
        }
        startActivity(new Intent(this, activityClass));
        finish();
    }

    @Override
    public void onBackPressed() {

    }
}
