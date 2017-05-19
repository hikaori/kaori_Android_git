package com.example.kaorihirata.practicecountryquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button mtrueButton;
    public Button mfalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
//    private Question[] mQuestionBank = new Question[] { //下記と同様のもの（書き方が違うだけ）
    private Question[] mQuestionBank = {
            new Question(R.string.question_canada,false),
            new Question(R.string.question_japan,false),
            new Question(R.string.question_us,false),
            new Question(R.string.question_korea,false),
//        new Question  (TextView) findViewById(R.id.question_france);
    };

    private int mCurrentIndex=0; //　何番目の質問か取得する為のもの

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mQuestionTextView =(TextView) findViewById(R.id.question_text);
        updateQuestion();

        mtrueButton = (Button) findViewById(R.id.true_button); //(Button)を書くことで〇〇をButton typeに変換。（down cast）
        mtrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });

        mfalseButton = (Button) findViewById(R.id.false_button);
        mfalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_LONG).show();
//                Toast tost = Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_LONG);
//                tost.show();
//                tost.setGravity(0, 0, 0);
                checkAnswer(false);
            }
        });

        mNextButton = (Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, R.string.next_button, Toast.LENGTH_SHORT).show();
                // next button pressed!
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
    }
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);//what is this?
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTure();
        int messageResId = 0;
        if(answerIsTrue==userPressedTrue){
            messageResId = R.string.correct_toast;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }
        Toast toast= Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT);
        toast.show();
        toast.setGravity(0, 0, 0);
    }
}
