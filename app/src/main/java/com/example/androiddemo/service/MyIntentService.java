package com.example.androiddemo.service;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

class MyIntentService extends IntentService {


    public MyIntentService() {
        super("MyIntentService");
    }

    protected void onHandleIntent(@Nullable Intent intent) {

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
