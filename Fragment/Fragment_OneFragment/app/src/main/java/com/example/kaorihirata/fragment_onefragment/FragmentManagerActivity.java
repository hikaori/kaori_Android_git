package com.example.kaorihirata.fragment_onefragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FragmentManagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_manager);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentA fragmenta = new FragmentA();
        fragmentManager.beginTransaction().add(R.id.fragment_container, fragmenta).commit();

        // this below 5 Line(follow with android documents)  is same as upper 3 line(original).
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

//        FragmentA fragmenta = new FragmentA();
//        fragmentTransaction.add(R.id.fragment_container, fragmenta);
//        fragmentTransaction.commit();



    }
}
