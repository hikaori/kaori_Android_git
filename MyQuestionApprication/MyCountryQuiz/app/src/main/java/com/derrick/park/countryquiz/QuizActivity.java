package com.derrick.park.countryquiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private TextView mQuestionArea;
    private Button mTureButton;
    private Button mFalseButton;
    private Button mPreviousButton;
    private Button mNextButton;
    private int mCurrentQuestionIndex = 0;

    private Questions[] mQuestionBank = new Questions[] {
            new Questions(R.string.question_text1, false),
            new Questions(R.string.question_text2, true),
            new Questions(R.string.question_text3, true),
            new Questions(R.string.question_text4, true),
            new Questions(R.string.question_text5, false)
    };
///   basic style array instantiate code.
//    Questions Q1 = new Questions(R.string.question_text1, true);
//    Questions Q2 = new Questions(R.string.question_text2, true);
//    Questions Q3 = new Questions(R.string.question_text3, true);
//    Questions Q4 = new Questions(R.string.question_text4, true);
//    Questions Q5 = new Questions(R.string.question_text5, true);
//    private Questions[] mQuestionBank = {Q1, Q2, Q3, Q4, Q5};
//    String[] wordArray = {"Apple", "Orange", "Pear", "Kiwi", "Banana"}; // Array instantiation reference


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mQuestionArea = (TextView) findViewById(R.id.question_area);
        mQuestionArea.setText(mQuestionBank[0].getQuestionStringID());
        mQuestionArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //** increment "mCurrentQuestionIndex", handle happening when "mCurrentQuestionIndex" count over Question's Number using "if"
//                mCurrentQuestionIndex++;
//                if (mCurrentQuestionIndex == mQuestionBank.length) {
//                    mCurrentQuestionIndex = 0;
//                }
                mCurrentQuestionIndex = (mCurrentQuestionIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

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
                Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
            }
        });

        mPreviousButton = (Button) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentQuestionIndex--;
                if (mCurrentQuestionIndex < 0) {
                    mCurrentQuestionIndex = mQuestionBank.length - 1;
                }
                updateQuestion();
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //** increment "mCurrentQuestionIndex", handle happening when "mCurrentQuestionIndex" count over Question's Number using "if"
//                mCurrentQuestionIndex++;
//                if (mCurrentQuestionIndex == mQuestionBank.length) {
//                    mCurrentQuestionIndex = 0;
//                }
                mCurrentQuestionIndex = (mCurrentQuestionIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
    }

    private void updateQuestion() {
        int QuestionNum = mQuestionBank[mCurrentQuestionIndex].getQuestionStringID();
        mQuestionArea.setText(QuestionNum);
    }
}


