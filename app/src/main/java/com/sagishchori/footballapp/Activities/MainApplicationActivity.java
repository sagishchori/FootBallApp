package com.sagishchori.footballapp.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sagi Shchori on 20/11/2017.
 */

public abstract class MainApplicationActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(getViewResourceId());
    }

    /**
     * Use this method to get the layout resource Id to be used in {@code setContentView}. This must
     * be implemented in all subclasses.
     * @return  The resource id
     */
    protected abstract int getViewResourceId();
}