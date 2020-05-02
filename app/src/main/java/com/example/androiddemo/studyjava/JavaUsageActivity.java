package com.example.androiddemo.studyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.androiddemo.R;

public class JavaUsageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_usage);
    }
}

interface RequestCallBack {

    public void onSuccess();
    public void onFail();
}