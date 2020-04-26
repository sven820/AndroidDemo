package com.example.androiddemo.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.androiddemo.R;

import androidx.annotation.Nullable;

public class JJNavbarLayout extends LinearLayout {
    public JJNavbarLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.navbar, this);

        Button leftbtn = findViewById(R.id.back);
        leftbtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }
}
