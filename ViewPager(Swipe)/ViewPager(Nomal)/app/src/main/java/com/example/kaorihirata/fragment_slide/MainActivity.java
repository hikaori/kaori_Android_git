package com.example.kaorihirata.fragment_slide;

//*reference you tube ▼
//https://www.youtube.com/watch?v=nL0k2usU7I8&t=759s

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
    ViewPager mViewPager;
    SwipeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mAdapter = new SwipeAdapter(this);
        mViewPager.setAdapter(mAdapter);

    }



}
