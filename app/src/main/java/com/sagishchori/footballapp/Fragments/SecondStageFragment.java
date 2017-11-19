package com.sagishchori.footballapp.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sagishchori.footballapp.R;

/**
 * Created by user on 05/10/2017.
 */

public class SecondStageFragment extends Fragment
{
    public static final String TAG = SecondStageFragment.class.getSimpleName()
            ;

    public static SecondStageFragment newInstance(Bundle bundle)
    {
        SecondStageFragment secondStageFragment = new SecondStageFragment();
        secondStageFragment.setArguments(bundle);
        return secondStageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_second_stage, container, false);
    }
}
