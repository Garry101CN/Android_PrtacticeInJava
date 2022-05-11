package com.garroid.androidadvancejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class InvalidTextViewTest extends AppCompatActivity {

    private TitleBar mTitleBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_invalid_text_view);
        mTitleBar = (TitleBar) this.findViewById(R.id.title);
        // mTitleBar.setTitle("自定义组合控件");

        mTitleBar.setLeftListener((v) -> {
            Toast.makeText(InvalidTextViewTest.this, "点击左键", Toast.LENGTH_SHORT).show();
        });

        mTitleBar.setRightListener((v) -> {
            Toast.makeText(InvalidTextViewTest.this, "点击右键", Toast.LENGTH_SHORT).show();
        });
    }
}