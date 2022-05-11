package com.garroid.androidadvancejava;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;

public class MovableViewActivity extends AppCompatActivity {

    private CustomView mCustomView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movable_view);

        mCustomView = findViewById(R.id.customview);
        // 魂不动动画，点击原来的位置才能响应
        // mCustomView.setAnimation(AnimationUtils.loadAnimation(this, R.anim.translate));
        // 魂也动动画
        //ObjectAnimator.ofFloat(mCustomView, "translationX", 0, 300).setDuration(1000).start();
        // scrollTo scrollBy 见CustomView
        mCustomView.smoothScrollTo(-400, 0);
    }


}