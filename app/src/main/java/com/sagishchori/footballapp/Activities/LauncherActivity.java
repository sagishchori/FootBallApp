package com.sagishchori.footballapp.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.facebook.Profile;
import com.sagishchori.footballapp.Models.UserData;
import com.sagishchori.footballapp.R;
import com.sagishchori.footballapp.Utils.SharedPreferencesWrapper;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Sagi Shchori on 20/11/2017.
 */

public class LauncherActivity extends MainApplicationActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Timer timer = new Timer();
        timer.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                if (Profile.getCurrentProfile() == null)
                    startSignInActivity();
                else if (SharedPreferencesWrapper.with(LauncherActivity.this).getStringData(UserData.USER_EMAIL).equals(""))
                    startSignInActivity();
                else
                    startMainActivity();
            }
        }, 1500);
    }

    @Override
    protected int getViewResourceId()
    {
        return R.layout.activity_launcher;
    }

    private void startMainActivity()
    {
        Intent intent = new Intent(LauncherActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void startSignInActivity()
    {
        Intent intent = new Intent(LauncherActivity.this, SignInActivity.class);
        startActivity(intent);
        finish();
    }
}