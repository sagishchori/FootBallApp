package com.sagishchori.footballapp.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.sagishchori.footballapp.Fragments.FirstStageFragment;
import com.sagishchori.footballapp.Fragments.SecondStageFragment;
import com.sagishchori.footballapp.R;

/**
 * Created by user on 05/10/2017.
 */

public class GameActivity extends MainApplicationActivity
{
    public static final String EXTRA_GAME_STAGE = "EXTRA_GAME_STAGE";
    public static final String FIRST_STAGE = "FIRST_STAGE";
    public static final String SECOND_STAGE = "SECOND_STAGE";

    private FrameLayout frameLayout;
    private TextView header;
    private int currentStage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        frameLayout = (FrameLayout) findViewById(R.id.content);
        header = (TextView) findViewById(R.id.stage_text_view);

        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(EXTRA_GAME_STAGE))
            showFragment(getIntent().getExtras().getString(EXTRA_GAME_STAGE, FIRST_STAGE));
        else
            showFragment(FIRST_STAGE);
    }

    @Override
    protected int getViewResourceId()
    {
        return R.layout.activity_game;
    }

    private void showFragment(String stage)
    {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment fragment = getFragment(stage, fragmentManager);

        if (fragment == null)
            return;

        transaction.replace(frameLayout.getId(), fragment, stage).commit();
    }

    private Fragment getFragment(String whichTab, FragmentManager fragmentManager)
    {
        Bundle bundle = null;
        switch (whichTab)
        {
            case FIRST_STAGE:
                FirstStageFragment firstStageFragment;
                if ((firstStageFragment = (FirstStageFragment) fragmentManager.findFragmentByTag(FirstStageFragment.TAG)) != null)
                    return firstStageFragment;
                else
                    return FirstStageFragment.newInstance(bundle);

            case SECOND_STAGE:
                SecondStageFragment secondStageFragment;
                if ((secondStageFragment = (SecondStageFragment) fragmentManager.findFragmentByTag(SecondStageFragment.TAG)) != null)
                    return secondStageFragment;
                else
                    return SecondStageFragment.newInstance(bundle);

            default:
                return null;
        }
    }
}
