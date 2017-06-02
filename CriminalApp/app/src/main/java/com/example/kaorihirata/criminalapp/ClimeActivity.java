package com.example.kaorihirata.criminalapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ClimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //getSupportFragmentManager()
        //  >>Return the FragmentManager for interacting with fragments associated with this activity.
        FragmentManager fm = getSupportFragmentManager();

        // at the time not exist any fragment in FragmentManager.
        Fragment fragment =fm.findFragmentById(R.id.fragment_container);

        if(fragment==null){
            fragment = new CrimeFragment();

            //beginTransaction()
            //  >>Start a series of edit operations on the Fragments associated with this FragmentManager.
            fm.beginTransaction().add(R.id.fragment_container,fragment).commit();
        }
    }
}
