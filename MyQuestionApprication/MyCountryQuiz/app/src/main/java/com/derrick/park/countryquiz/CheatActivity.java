package com.derrick.park.countryquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CheatActivity extends AppCompatActivity {
    private Button mShow_answer_button;
    private TextView mCheatAnswer_text;
    private Boolean mgetQA;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mgetQA = getIntent().getExtras().getBoolean("EXTRA_key_Cheat");

        mShow_answer_button = (Button) findViewById(R.id.show_answer_button);
        mShow_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCheatAnswer_text = (TextView) findViewById(R.id.cheatAnswer_text);
                if (mgetQA) {
                    mCheatAnswer_text.setText(R.string.true_button);
                } else {
                    mCheatAnswer_text.setText(R.string.false_button);
                }
            }
        });
    }
}
