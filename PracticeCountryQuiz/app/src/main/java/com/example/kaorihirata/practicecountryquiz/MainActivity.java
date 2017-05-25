package com.example.kaorihirata.practicecountryquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mtrueButton;
    private Button mfalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private TextView mQuestionTextView;
    //    private Question[] mQuestionBank = new Question[] { //下記と同様のもの（書き方が違うだけ）
    private Question[] mQuestionBank = {
            new Question(R.string.question_canada, false),
            new Question(R.string.question_japan, false),
            new Question(R.string.question_us, false),
            new Question(R.string.question_korea, false),
            new Question(R.string.question_france, false),
            new Question(R.string.question_6, false),
            new Question(R.string.question_7, false),
            new Question(R.string.question_8, false),
            new Question(R.string.question_9, false),
            new Question(R.string.question_10, false),
    };

    private int mCurrentIndex = 0; //　何番目の質問か取得する為のもの
    private static final String TAG = "QuizActivity";
    private static final String KEY = "index"; // for Activity Life Cycle
    private int scor;// count corrected time

    //メインのコード
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate");

        //Activity Life Cycle 対応
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY, 0);
        }

        //質問表示
        mQuestionTextView = (TextView) findViewById(R.id.question_text);
        mQuestionTextView.setText(mQuestionBank[mCurrentIndex].getTextResId()); //デフォルト質問または、前回の質問を表示。


        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // next button pressed!
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });



        mtrueButton = (Button) findViewById(R.id.true_button); //(Button)を書くことで〇〇をButton typeに変換。（down cast）
        mtrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
                updateButtons(true);
            }
        });

        mfalseButton = (Button) findViewById(R.id.false_button);
        mfalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
                updateButtons(true);
            }
        });

        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // previous button pressed!
                mCurrentIndex = mCurrentIndex - 1;
                if (mCurrentIndex < 0) {
                    mCurrentIndex = mQuestionBank.length - 1; // lenghtは要素数
                }
                updateQuestion();
                updateButtons(false);
            }
        });

        mNextButton = (ImageButton) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // next button pressed!
                mCurrentIndex = (mCurrentIndex + 1);
//                visibleButton();
                if(mCurrentIndex== mQuestionBank.length) {
                    double percentage = ((double) scor / mQuestionBank.length) * 100;
                    Toast.makeText(MainActivity.this, "The score is " + percentage + "%", Toast.LENGTH_SHORT).show();
                    scor = 0;
                }
                mCurrentIndex%=mQuestionBank.length;
                updateQuestion();
                updateButtons(false);
                }
        });
    }

    //Activity Life Cycle 対応（appを閉じる前のindex番号を取得しておく）
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(KEY, mCurrentIndex);
    }

    //一度答えたらボタンを非常にする。
    private void updateButtons(boolean ansowerd){
        mfalseButton.setEnabled(!ansowerd);
        mtrueButton.setEnabled(!ansowerd);
    }

    //メインのサポート
    private void updateQuestion() {
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTure();
        int messageResId = 0;
        if (answerIsTrue == userPressedTrue) {
            messageResId = R.string.correct_toast;
            scor++;//teacher
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast toast = Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(0, 0, 0);
    }

    //Button Invisible
    private void invisibleButton() {
        mtrueButton.setVisibility(View.GONE);
        mfalseButton.setVisibility(View.GONE);
    }

    //Button visible
    private void visibleButton() {
        mtrueButton.setVisibility(View.VISIBLE);
        mfalseButton.setVisibility(View.VISIBLE);
    }

    //for Activity Life Cycle
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
