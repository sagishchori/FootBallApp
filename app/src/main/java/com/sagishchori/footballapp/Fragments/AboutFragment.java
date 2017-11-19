package com.sagishchori.footballapp.Fragments;

import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by user on 01/10/2017.
 */

public class AboutFragment extends Fragment {

    public static final String TAG = AboutFragment.class.getSimpleName();

    public static AboutFragment newInstance(Bundle bundle)
    {
        AboutFragment aboutFragment = new AboutFragment();
        aboutFragment.setArguments(bundle);
        return aboutFragment;
    }

}
