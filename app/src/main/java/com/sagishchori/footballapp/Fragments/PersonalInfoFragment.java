package com.sagishchori.footballapp.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sagishchori.footballapp.R;

/**
 * Created by user on 01/10/2017.
 */

public class PersonalInfoFragment extends Fragment implements View.OnClickListener{

    public static final String TAG = PersonalInfoFragment.class.getSimpleName();

    private TextView name;
    private TextView email;

    private TextView signInButton;

    public static PersonalInfoFragment newInstance(Bundle bundle)
    {
        PersonalInfoFragment personalInfoFragment = new PersonalInfoFragment();
        personalInfoFragment.setArguments(bundle);
        return personalInfoFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {

        return inflater.inflate(R.layout.fragment_personal_info, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        name = (TextView) view.findViewById(R.id.name);
        email = (TextView) view.findViewById(R.id.email);

        signInButton = (TextView) view.findViewById(R.id.sign_in_button);
        signInButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        switch (view.getId())
        {
            case R.id.sign_in_button:
                break;

            default:
                break;
        }
    }
}
