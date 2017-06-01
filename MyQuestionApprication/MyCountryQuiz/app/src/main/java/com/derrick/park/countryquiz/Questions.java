package com.derrick.park.countryquiz;

/**
 * Created by kaorihirata on 2017-05-25.
 */

public class Questions {
    private int mQuestionStringID;
    private boolean mAnswertrue;

    public Questions(int QId,boolean QA) {
        this.mQuestionStringID = QId;
        this.mAnswertrue = QA;
    }

    public int getQuestionStringID() {
        return mQuestionStringID;
    }

    public boolean isAnswertrue() {
        return mAnswertrue;
    }
}
