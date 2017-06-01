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
    private TextView mQuestionArea;
    private Button mTureButton;
    private Button mFalseButton;
    private Button mCheatButton;
    private Button mPreviousButton;
    private Button mNextButton;
    private int mCurrentQuestionIndex = 0;
    private int mCorrectedCount;
    private TextView mPercentArea;
    private Questions[] mQuestionBank = new Questions[]{
            new Questions(R.string.question_text1, false),
            new Questions(R.string.question_text2, true),
            new Questions(R.string.question_text3, true),
            new Questions(R.string.question_text4, true),
            new Questions(R.string.question_text5, false)
    };
    //value for file cycle
    private static final String TAG = "QuizActivity";
    private static final String mLastQuestion = "LastQuestion";
    //value for create other activity
    private static final int REQUEST_CODE=0;
    public static final String EXTRA_key_Cheat = "EXTRA_key_Cheat";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        // Check whether we're recreating a previously destroyed instance
        //"savedInstanceState" is a Bundle object containing the activity's previously saved state.
        if (savedInstanceState != null) {
            mCurrentQuestionIndex = savedInstanceState.getInt(mLastQuestion);
        }

        mQuestionArea = (TextView) findViewById(R.id.question_area);
        mQuestionArea.setText(mQuestionBank[mCurrentQuestionIndex].getQuestionStringID());

        //go to next Question when ten text Area clicked
        mQuestionArea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextQuestion();
            }
        });


        mTureButton = (Button) findViewById(R.id.true_button);
        mTureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                visibleButton(false);
            }
        });


        mFalseButton = (Button) findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                visibleButton(false);
            }
        });


        mCheatButton = (Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // variable(this Class, go to other Class)
                Intent i = new Intent(QuizActivity.this, CheatActivity.class);
                boolean QA=mQuestionBank[mCurrentQuestionIndex].isAnswertrue();
                i.putExtra(EXTRA_key_Cheat, QA );
                startActivity(i);
//                startActivityForResult(i,REQUEST_CODE);
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
                visibleButton(true);
            }
        });


        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToNextQuestion();
            }
        });
    }

    private void goToNextQuestion(){
        percentage();
        mCurrentQuestionIndex = (mCurrentQuestionIndex + 1) % mQuestionBank.length;
        updateQuestion();
        visibleButton(true);
    }

    protected void updateQuestion() {
        int QuestionNum = mQuestionBank[mCurrentQuestionIndex].getQuestionStringID();
        mQuestionArea.setText(QuestionNum);
    }

    //true > visibleButton / false > unvisible
    private void visibleButton(boolean able) {
        mTureButton.setEnabled(able);
        mFalseButton.setEnabled(able);
    }

    private void checkAnswer(boolean QAnswer) {
        if (mQuestionBank[mCurrentQuestionIndex].isAnswertrue() == QAnswer) {
            Toast.makeText(QuizActivity.this, R.string.correct_toast, Toast.LENGTH_LONG).show();
            mCorrectedCount++;
        } else {
            Toast.makeText(QuizActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG).show();
        }
    }

    private void percentage(){
        if(mCurrentQuestionIndex==mQuestionBank.length-1){
            double percentage = ((double)mCorrectedCount/mQuestionBank.length)*100;
//            mPercentArea=(TextView)findViewById(R.id.percent_area);
//            mPercentArea.setText("your score is"+percentage+"%");
            Toast.makeText(QuizActivity.this, "your score is"+percentage+" %", Toast.LENGTH_LONG).show();
        }
    }

    // life cycle
    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the current Question state
        savedInstanceState.putInt(mLastQuestion, mCurrentQuestionIndex);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }
}



