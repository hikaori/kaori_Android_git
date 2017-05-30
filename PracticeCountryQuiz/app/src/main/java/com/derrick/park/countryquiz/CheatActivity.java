package com.derrick.park.countryquiz;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private TextView mApiLevelTextView;
    private Button mShowAnswerButton;
    private TextView mAnswerTextView;
    private boolean mAnswerTrue;
    private boolean mIsCheated;
    private static final String EXTRA_ANSWER_IS_TRUE = "com.derrick.park.countryquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.derrick.park.countryquiz.answer_shown";
    private static final String KEY_INDEX = "cheated";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        mApiLevelTextView = (TextView)findViewById(R.id.api_level);
        // setText of value is CharSequence. using "Integer.toString" change int to String.(CharSequence)
        mApiLevelTextView.setText("this API Level is "+Integer.toString(Build.VERSION.SDK_INT));


        mAnswerTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
        mAnswerTextView = (TextView) findViewById(R.id.answer_text_view);
        if (savedInstanceState != null) {
            mIsCheated = savedInstanceState.getBoolean(KEY_INDEX, false);
            updateAnswer();
            setAnswerShownResult(mIsCheated);
        }

        mShowAnswerButton = (Button) findViewById(R.id.show_answer_button);

        // When the user presses the ShowAnswer Button, this activity packages up
        // the result code and the intent in the call to setResult(int, intent)
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // showAnswerButton -> inform first activity to know that user cheated.
                updateAnswer();
                mIsCheated = true;
                setAnswerShownResult(mIsCheated);

                // New Animation API 21 (Lollipop)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    int cx = mShowAnswerButton.getWidth() / 2;
                    int cy = mShowAnswerButton.getHeight() / 2;
                    float radius = mShowAnswerButton.getWidth();
                    Animator anim = ViewAnimationUtils.createCircularReveal(mShowAnswerButton, cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            mShowAnswerButton.setVisibility(View.INVISIBLE);

                        }
                    });
                    anim.start();

                } else {
                    mShowAnswerButton.setVisibility(View.INVISIBLE);
                }

            }
        });

    }

    private void updateAnswer() {
        if (mAnswerTrue) {
            mAnswerTextView.setText(R.string.true_button);
        } else {
            mAnswerTextView.setText(R.string.false_button);
        }
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);

        return intent;
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);

        // Setting a result code is useful when the parent activity needs to take
        // different action depending on how child activiy is finished.
        setResult(RESULT_OK, data);
    }

    public static boolean wasAnswerShown(Intent result){
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean(KEY_INDEX, mIsCheated);
    }
}
