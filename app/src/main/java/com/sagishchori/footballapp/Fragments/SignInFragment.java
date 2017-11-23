package com.sagishchori.footballapp.Fragments;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.telephony.gsm.SmsMessage;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.sagishchori.footballapp.Models.UserData;
import com.sagishchori.footballapp.R;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Sagi Shchori on 22/11/2017.
 */

public class SignInFragment extends Fragment
{
    public static final String TAG = SignInFragment.class.getSimpleName();

    private View rootView;
    private LoginButton loginButton;
    private CallbackManager callbackManager;

    public static SignInFragment newInstance(Bundle bundle)
    {
        SignInFragment signInFragment = new SignInFragment();
        signInFragment.setArguments(bundle);
        return signInFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_signin, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rootView = view;

        loginButton = (LoginButton) view.findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");
        // If using in a fragment
        loginButton.setFragment(this);
        // Other app specific specialization

        callbackManager = CallbackManager.Factory.create();

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                /* make the API call */
                new GraphRequest(
                        AccessToken.getCurrentAccessToken(),
                        "/me?fields=email, name",
                        null,
                        HttpMethod.GET,
                        new GraphRequest.Callback() {
                            public void onCompleted(GraphResponse response) {
                            /* handle the result */
                            JSONObject jsonObject = response.getJSONObject();
                            UserData userData = new UserData();
                                try {
                                    userData.setEmail(jsonObject.getString(UserData.USER_EMAIL));
                                    userData.setName(jsonObject.getString(UserData.USER_NAME));
                                    userData.setFacebookID(jsonObject.getString(UserData.USER_FACEBOOK_ID));
                                    userData.setUserDataToSharedPreferences(getActivity());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                ).executeAsync();
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
