package com.garroid.androidadvancejava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DIYViewGallery extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diyview_gallery);

        Button sysViewExt = findViewById(R.id.systemViewExt);
        sysViewExt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DIYViewGallery.this, InvalidTextViewTest.class));
            }
        });
    }
}