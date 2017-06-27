package com.example.kaorihirata.userlocation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            geoLocate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void geoLocate() throws IOException {
        TextView mtvel = (TextView) findViewById(R.id.tvEnterLocation);
        TextView mtvlat = (TextView) findViewById(R.id.tvlat);
        TextView mtvlng = (TextView) findViewById(R.id.tvlng);
        String mlocation = mtvel.getText().toString();

        Geocoder mgc = new Geocoder(this);
        List<Address> list = mgc.getFromLocationName(mlocation, 1);
        // Get the first and only item in the list
        Address maddressadd = list.get(0);
        String locality = maddressadd.getLocality();

        double mlat = maddressadd.getLatitude();
        double mlng = maddressadd.getLongitude();

        mtvlat.setText("Latitude:" + mlat);
        mtvlng.setText("longitude:" + mlng);

    }
}
