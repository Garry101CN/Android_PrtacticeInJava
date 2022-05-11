package com.garroid.androidadvancejava;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

public class Question {

    private int textResId;
    private boolean answer;

    public int getTextResId() {
        return textResId;
    }

    public void setTextResId(int textResId) {
        this.textResId = textResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }


    public Question(int textResId, boolean answer){
        this.textResId = textResId;
        this.answer = answer;

    }



}
