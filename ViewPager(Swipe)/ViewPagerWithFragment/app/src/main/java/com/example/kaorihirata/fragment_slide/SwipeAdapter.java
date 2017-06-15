package com.example.kaorihirata.fragment_slide;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;

/**
 * Created by kaorihirata on 2017-06-14.
 */

public class SwipeAdapter extends FragmentStatePagerAdapter {

    Fragment[] imgFragment ={new Fragment1_dog(),new Fragment2_cat(),new Fragment3_beach()};

    public SwipeAdapter(FragmentManager fm) {
        super(fm);
    }
//　MUST OVERRIDE METHOD 'getItem(int position)' / 'getCount()' WHEN USE 'FragmentStatePagerAdapter'
    @Override
    public Fragment getItem(int position) {
        return imgFragment[position];
    }

    @Override
    public int getCount() {
        return imgFragment.length;
    }

}
