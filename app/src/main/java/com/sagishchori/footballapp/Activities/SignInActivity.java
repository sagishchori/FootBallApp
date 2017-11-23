package com.sagishchori.footballapp.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;

import com.sagishchori.footballapp.Fragments.SignInFragment;
import com.sagishchori.footballapp.R;

/**
 * Created by Sagi Shchori on 20/11/2017.
 */

public class SignInActivity extends MainApplicationActivity
{
    public static final String SIGN_IN = "SIGN_IN";
    public static final String SIGN_UP = "SIGN_UP";

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        frameLayout = (FrameLayout) findViewById(R.id.content);

        showFragment(SIGN_IN);
    }

    /**
     * Show the requested {@link Fragment} according to user selection
     * @param whichTab  Which navigation tab the user selected
     */
    private void showFragment(String whichTab)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment fragment = getFragment(whichTab, fragmentManager);
        String fragmentTag = getFragmentTag(whichTab);

        if (fragment == null || fragmentTag == null)
            return;

        transaction.replace(frameLayout.getId(), fragment, fragmentTag).commit();
    }

    /**
     * Get the requested {@link Fragment}. If the {@link Fragment} != null return it, otherwise return newInstance() of it
     * @param whichTab          Which navigation tab the user selected
     * @param fragmentManager
     * @return                  The requested {@link Fragment}
     */
    private Fragment getFragment(String whichTab, FragmentManager fragmentManager)
    {
        Bundle bundle = null;
        switch (whichTab)
        {
            case SIGN_IN:
                SignInFragment signInFragment;
                if ((signInFragment = (SignInFragment) fragmentManager.findFragmentByTag(SignInFragment.TAG)) != null)
                    return signInFragment;
                else
                    return SignInFragment.newInstance(bundle);

            default:
                return null;
        }
    }

    /**
     * Get the TAG of the requested {@link Fragment}
     * @param whichTab  The navigation tab the user selected
     * @return          The {@link Fragment}'s TAG
     */
    private String getFragmentTag(String whichTab)
    {
        switch (whichTab)
        {
            case SIGN_IN:
                return SignInFragment.TAG;

//            case SIGN_UP:
//                return ;

            default:
                return null;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected int getViewResourceId()
    {
        return R.layout.activity_signin;
    }
}