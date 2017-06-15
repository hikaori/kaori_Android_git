package com.example.kaorihirata.fragment1page2fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by kaorihirata on 2017-06-14.
 */

/**1.extend "Fragment"
 * 2.write 'onCreateView'
 * 3. write 'View v = inflater.inflate(R.layout.fragment_layout,container,false);'
 */

public class Fragment2 extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2_layout,container,false);
        return v;
    }
}
