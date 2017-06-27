package com.example.kaorihirata.intentandbandle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Page2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        TextView username = (TextView) findViewById(R.id.userName);

//////////////////  USING 'Intent' VER //////////////////
//        username.setText(getIntent().getExtras().getString("ExtraKey"));

//////////////////  USING 'Intent' VER //////////////////
        username.setText(getIntent().getExtras().getString("ExtraKey"));
    }
}
