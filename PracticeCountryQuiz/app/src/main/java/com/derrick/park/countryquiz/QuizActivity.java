package com.derrick.park.countryquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    private boolean mIsCheater;
    private Question[] mQuestionBank = new Question[] {
            new Question(R.string.question_canada, false),
            new Question(R.string.question_france, true),
            new Question(R.string.question_japan, true),
            new Question(R.string.question_korea, true),
            new Question(R.string.question_usa, false)
    };
    private int mCurrentIndex = 0;
    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "index";
    private static final String CHEATER_INDEX = "cheater";
    private static final int REQUEST_CODE = 0;
    private int score = 0;
    private int mCheatCount=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate(Bundle savedInstanceState) called.");
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
            mIsCheater = savedInstanceState.getBoolean(CHEATER_INDEX, false);
        }

        mQuestionTextView = (TextView) findViewById(R.id.question_text);
        updateQuestion();

        mTrueButton = (Button) findViewById(R.id.true_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateButtons(true);
            }
        });

        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateButtons(true);
            }
        });

        mCheatButton = (Button) findViewById(R.id.cheat_button);
            mCheatButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // start my cheatActivity
                    boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
                    Intent intent = CheatActivity.newIntent(QuizActivity.this, answerIsTrue);

                    // request code is a user-defined integer that is sent to the child
                    // activity and then received back by the parent.
                    // It is used when an activity starts more than one type of child activity
                    // and needs to know who is reporting back.
                    startActivityForResult(intent, REQUEST_CODE);
                }
            });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (!mIsCheater) {
                    mCurrentIndex = (mCurrentIndex + 1);

                    if (mCurrentIndex == mQuestionBank.length) {
                        double percentage = ((double) score / mQuestionBank.length) * 100;
                        Toast.makeText(QuizActivity.this, "The score is " + percentage + "%", Toast.LENGTH_SHORT).show();
                        score = 0;
                    }
                    mCurrentIndex %= mQuestionBank.length;
                    updateQuestion();
                    updateButtons(false);
//                } else {
//                    Toast.makeText(QuizActivity.this, R.string.judgement_text, Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }


    // when the user presses Back button to return to our QuizActivity, the Android
    // ActivityManager calls this method.
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // unpackage the intent data
        if (resultCode != RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE) {
            if (data == null) {
                return;
            }
            mIsCheater = CheatActivity.wasAnswerShown(data);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(KEY_INDEX, mCurrentIndex);
        outState.putBoolean(CHEATER_INDEX, mIsCheater);

    }

    private void updateQuestion() {
//        Log.d(TAG, "Updating question text", new Exception());
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void updateButtons(boolean answered) {
        mFalseButton.setEnabled(!answered);
        mTrueButton.setEnabled(!answered);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResId = 0;
        if (mIsCheater) {
            messageResId = R.string.judgement_text;
        } else {
            if (answerIsTrue == userPressedTrue) {
                messageResId = R.string.correct_toast;
                score++;
            } else {
                messageResId = R.string.incorrect_toast;
            }
        }

        Toast.makeText(QuizActivity.this, messageResId, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called.");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called.");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called.");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called.");
    }

}
