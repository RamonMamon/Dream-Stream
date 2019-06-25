package com.example.dreamstream;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{

    private Switch joinNetworkSwitch;
    private CallbackManager callbackManager;
    private static final String EMAIL = "email";
    private LoginButton loginButton;
    private boolean isLoggedIn;
    private AccessToken accessToken;
    private String PREF_NAME = "switch1_state";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        accessToken = AccessToken.getCurrentAccessToken();
        joinNetworkSwitch = findViewById(R.id.switch1);

        try
        {
            isLoggedIn = accessToken != null || !accessToken.isExpired();

        }catch (NullPointerException e)
        {
            e.printStackTrace();
        }

        SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
        boolean silent = settings.getBoolean("switchkey", false);

        // Only keeps the switch on if the user is logged in.
        joinNetworkSwitch.setChecked(isLoggedIn && silent);

        joinNetworkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if (isChecked)
                {
                    System.out.println("Checking");

                    // Connect Facebook account (If not already connected)
                    if(!isLoggedIn)
                    {
                        // Popup that the user should connect their facebook account first.

                        System.out.println("Please connect Facebook account first prior to connecting to the network.");

                        //
                        joinNetworkSwitch.setChecked(false);
                    }else
                    {
                        System.out.println("Connected to the Dream network.");
                        System.out.println("Access Token: " + accessToken.getToken());
                        // Send friend request on facebook

                        // Listen out for any Facebook Live streams.

                    }

                    // Follow this process to watch the live streams of users on the dream network.

                }else
                {
                    System.out.println("Unchecking");

                    // Remove Dream network from list of friends.

                }
                SharedPreferences settings = getSharedPreferences(PREF_NAME, 0);
                SharedPreferences.Editor editor = settings.edit();
                editor.putBoolean("switchkey", isChecked);
                editor.commit();
            }
        });

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions(Arrays.asList(EMAIL));
        // If you are using in a fragment, call loginButton.setFragment(this);

        // Callback registration
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                // login result contains the access token.
                accessToken = loginResult.getAccessToken();
                isLoggedIn = true;
                System.out.println("Login Successful");
                System.out.println("Access key:" + accessToken.getToken());
            }

            @Override
            public void onCancel() {
                // App code
                System.out.println("Login Cancelled");
            }

            @Override
            public void onError(FacebookException exception) {
                // App code
                System.out.println("Login Failed");
            }
        });

        // Access Token Listener
        AccessTokenTracker accessTokenTracker = new AccessTokenTracker() {
            @Override
            protected void onCurrentAccessTokenChanged(
                    AccessToken oldAccessToken,
                    AccessToken currentAccessToken) {

                if (currentAccessToken == null){
                    //User logged out
                    isLoggedIn = false;
                    accessToken = null;
                }
                else
                {
                    accessToken = currentAccessToken;
                    isLoggedIn = true;
                }
            }
        };
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*
        Every activity and fragment that you integrate with the FacebookSDK
        Login or Share should forward onActivityResult to the callbackManager.
         */

        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }
}
