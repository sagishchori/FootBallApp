package com.sagishchori.footballapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Sagi Shchori on 20/11/2017.
 */

public class SharedPreferencesWrapper
{
    private static final String FOOTBALL_APP_SHARED_PREFERENCES = "FOOTBALL_APP_SHARED_PREFERENCES";

    /**
     * Data types to be saved in Shared Preferences
     */
    public static final int TYPE_BOOLEAN = 1234;
    public static final int TYPE_STRING = 1235;
    public static final int TYPE_INT = 1236;

    private Context context;
    private static SharedPreferencesWrapper manager;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public SharedPreferencesWrapper(Context context)
    {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(FOOTBALL_APP_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public static SharedPreferencesWrapper with(Context context)
    {
        if (manager == null)
            return new SharedPreferencesWrapper(context);

        return manager;
    }

    public boolean setIntData(String key, int value)
    {
        return editor.putInt(key, value).commit();
    }

    public boolean setStringData(String key, String value)
    {
        return editor.putString(key, value).commit();
    }

    public boolean setBooleanData(String key, boolean value)
    {
        return editor.putBoolean(key, value).commit();
    }

    public int getIntData(String key)
    {
        return sharedPreferences.getInt(key, -1);
    }

    public String getStringData(String key)
    {
        return sharedPreferences.getString(key, "");
    }

    public boolean getBooleanData(String key)
    {
        return sharedPreferences.getBoolean(key, false);
    }
}