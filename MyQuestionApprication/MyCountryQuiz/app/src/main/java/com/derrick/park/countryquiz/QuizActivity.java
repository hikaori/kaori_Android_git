package com.derrick.park.countryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTureButton;
    private Button mFalseButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTureButton = (Button) findViewById(R.id.true_button);
        mTureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // anything you want when the button is pressed
                Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG);
//                Toast t = new Toast(QuizActivity.this);
//                t=Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG);
                t.show();
                t.setGravity(0,0,0);
            }
        });





    }
}
