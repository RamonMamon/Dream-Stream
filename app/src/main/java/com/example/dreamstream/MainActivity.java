package com.example.dreamstream;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{

    Switch joinNetworkSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        joinNetworkSwitch = findViewById(R.id.switch1);

        joinNetworkSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked)
            {
                if (isChecked)
                {
                    // Join the Dream Network

                    // Connect Facebook account

                    // Send Friend request on Facebook

                    // Listen out for any Facebook Live streams.

                    // Follow this process to watch the live streams of users on the dream network.

                    System.out.println("Checking");

                }else
                {
                    // Leave the dream network.

                    // Remove Dream network from list of friends.

                    System.out.println("Unchecking");

                }
            }
        });

    }

    /**
     * Joins the Dream network
     */
    private void joinNetwork()
    {
        // Connect Facebook account if not already connected

        // Add friend if not already friends on Facebook
    }

}
