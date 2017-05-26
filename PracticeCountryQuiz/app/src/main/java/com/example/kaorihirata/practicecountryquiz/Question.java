package com.example.kaorihirata.practicecountryquiz;

import android.widget.Button;

/**
 * Created by kaorihirata on 2017-05-19.
 */

public class Question {
    private int mTextResId;
    private  boolean mAnswerTure;

    public Question(int textResId,boolean answerTure){
        mTextResId=textResId;
        mAnswerTure=answerTure;
    }

    public int getTextResId() {
        return mTextResId;
    }

    public boolean isAnswerTure() {
        return mAnswerTure;
    }

    public void setTextResId(int TextResId) {
        this.mTextResId = TextResId;
    }

    public void setAnswerTure(boolean AnswerTure) {
        this.mAnswerTure = AnswerTure;
    }

}
