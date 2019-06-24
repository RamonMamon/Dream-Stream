package com.example.dreamstream;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity
{

    Switch joinNetworkSwitch;
    CallbackManager callbackManager;
    private static final String EMAIL = "email";
    LoginButton loginButton;
    boolean isLoggedIn;
    boolean inNetwork = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        AccessToken accessToken = AccessToken.getCurrentAccessToken();
//        isLoggedIn = accessToken != null || !accessToken.isExpired();

        joinNetworkSwitch = findViewById(R.id.switch1);

        joinNetworkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if (isChecked)
                {
                    // Join the Dream Network

                    // Connect Facebook account (If not already connected)
//                    if(!isLoggedIn)
//                    {
//                        login();
//                        joinNetwork();
//                    }
                    inNetwork = true;

                    // Send Friend request on Facebook

                    // Listen out for any Facebook Live streams.

                    // Follow this process to watch the live streams of users on the dream network.

                    System.out.println("Checking");

                }else
                {
                    // Leave the dream network.

                    // Remove Dream network from list of friends.
                    inNetwork = false;

                    System.out.println("Unchecking");

                }
            }
        });

//        callbackManager = CallbackManager.Factory.create();
//
//        loginButton = (LoginButton) findViewById(R.id.login_button);
//        loginButton.setReadPermissions(Arrays.asList(EMAIL));
//        // If you are using in a fragment, call loginButton.setFragment(this);
//
//        // Callback registration
//        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
//            @Override
//            public void onSuccess(LoginResult loginResult) {
//                // App code
//                // login result contains the access token.
//                System.out.println("Login Successful");
//                System.out.println("Access key:" + loginResult);
//            }
//
//            @Override
//            public void onCancel() {
//                // App code
//                System.out.println("Login Cancelled");
//            }
//
//            @Override
//            public void onError(FacebookException exception) {
//                // App code
//                System.out.println("Login Failed");
//            }
//        });


    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        /*
//        Every activity and fragment that you integrate with the FacebookSDK
//        Login or Share should forward onActivityResult to the callbackManager.
//         */
//
//        callbackManager.onActivityResult(requestCode, resultCode, data);
//        super.onActivityResult(requestCode, resultCode, data);
//    }

    /**
     * Connects the User's account to the application.
     */
    protected void login()
    {
        // Retrieve the access key.

        // Verify Access key
    }

    /**
     * Joins the Dream network (Add user on Facebook)
     */
    private void joinNetwork()
    {
        // Connect Facebook account if not already connected

        // Add friend if not already friends on Facebook
    }

}
