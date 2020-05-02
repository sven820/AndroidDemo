package com.example.androiddemo.service;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;

import com.example.androiddemo.R;

public class ServiceDemoActivity extends AppCompatActivity {

    MyService.DownloadBinder binder;

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            binder = (MyService.DownloadBinder)service;
            binder.startDownload();
            binder.getProgess();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_demo);


    }

    public void startIntentService() {
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }

    public void startService(View view) {
        startService(new Intent(this, MyService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(this, MyService.class));
    }

    public void bindService(View view) {
        bindService(new Intent(this, MyService.class), connection, BIND_AUTO_CREATE);
    }

    public void unbindService(View view) {
        unbindService(connection);
    }
}

