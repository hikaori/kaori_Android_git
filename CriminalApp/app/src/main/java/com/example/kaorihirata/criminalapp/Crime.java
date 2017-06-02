package com.example.kaorihirata.criminalapp;

import android.widget.CheckBox;

import java.util.Date;
import java.util.UUID;

/**
 * Created by kaorihirata on 2017-06-01.
 */

public class Crime {
    private String mTitle;
    private Date mDate;
    // UUID is identify id from android API
    private UUID mId;
    private Boolean mSolved;

    public void setSolved(Boolean solved) {
        mSolved = solved;
    }

    public Crime(){
        mId=UUID.randomUUID();
        mDate= new Date();
    }

    public String getTitle() {
        return mTitle;
    }

    public Date getDate() {
        return mDate;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setDate(Date date) {
        mDate = date;
    }
}
