package com.sagishchori.footballapp.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sagishchori.footballapp.Activities.GameActivity;
import com.sagishchori.footballapp.R;

/**
 * Created by user on 01/10/2017.
 */

public class HomeFragment extends Fragment implements View.OnClickListener, TextView.OnEditorActionListener
{
    public static final String TAG = HomeFragment.class.getSimpleName();

    private View rootView;
    private ImageView bannerImageView;
    private TextView startGameButton;
    private LinearLayout registrationLayout;
    private LinearLayout registrationView;

    private EditText fullName;
    private EditText mobile;
    private EditText email;

    private boolean isUserSignedIn = false;

    public static HomeFragment newInstance(Bundle bundle)
    {
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setArguments(bundle);
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragmet_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rootView = view;

        bannerImageView = (ImageView) view.findViewById(R.id.home_screen_banner);
        startGameButton = (TextView) view.findViewById(R.id.start_game_button);
        startGameButton.setOnClickListener(this);

        registrationLayout = (LinearLayout) view.findViewById(R.id.registration_layout);

        registrationView = (LinearLayout) registrationLayout.findViewById(R.id.registration_view);

        fullName = (EditText) registrationView.findViewById(R.id.registration_full_name);
        fullName.setOnEditorActionListener(this);
        mobile = (EditText) registrationView.findViewById(R.id.registration_mobile);
        mobile.setOnEditorActionListener(this);
        email = (EditText) registrationView.findViewById(R.id.registration_email);
        email.setOnEditorActionListener(this);

        setRegistrationView(isUserSignedIn);
    }

    private void setRegistrationView(boolean isUserSignedIn)
    {
        if (isUserSignedIn)
        {
            registrationView.setVisibility(View.GONE);
            startGameButton.setText(getActivity().getString(R.string.start_game_button_text));
        }
        else
        {
            registrationView.setVisibility(View.VISIBLE);
            fullName.post(new Runnable()
            {
                @Override
                public void run()
                {
                    fullName.requestFocus();
                }
            });
            startGameButton.setText(getActivity().getString(R.string.sign_up_text));
        }
    }

    @Override
    public void onClick(View view)
    {
        if (isUserSignedIn)
            startGameActivity();
        else
            Toast.makeText(getActivity(), "Registration succeeded", Toast.LENGTH_LONG).show();

        isUserSignedIn = !isUserSignedIn;
        setRegistrationView(isUserSignedIn);
    }

    private void startGameActivity()
    {
        Intent intent = new Intent(getActivity(), GameActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
    {
        if (i == EditorInfo.IME_ACTION_DONE)
            return false;

        return false;
    }
}
