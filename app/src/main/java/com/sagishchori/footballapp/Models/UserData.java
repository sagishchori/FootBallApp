package com.sagishchori.footballapp.Models;

import android.content.Context;

import com.sagishchori.footballapp.Utils.SharedPreferencesWrapper;

/**
 * Created by Sagi Shchori on 20/11/2017.
 */

public class UserData
{
    public static final String USER_NAME = "name";
    public static final String USER_EMAIL = "email";
    public static final String USER_FACEBOOK_ID = "id";
    public static final String USER_PASSWORD = "USER_PASSWORD";

    private String email;
    private String name;
    private String password;
    private String facebookID;

    public UserData()
    {
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getFacebookID()
    {
        return facebookID;
    }

    public void setFacebookID(String facebookID)
    {
        this.facebookID = facebookID;
    }

    public boolean setUserDataToSharedPreferences(Context context)
    {
        SharedPreferencesWrapper wrapper = SharedPreferencesWrapper.with(context);
        return wrapper.setStringData(USER_EMAIL, email) && wrapper.setStringData(USER_NAME, name) && wrapper.setStringData(USER_FACEBOOK_ID, facebookID);
    }
}