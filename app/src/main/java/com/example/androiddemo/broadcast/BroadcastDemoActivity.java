package com.example.androiddemo.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import com.example.androiddemo.R;

public class BroadcastDemoActivity extends AppCompatActivity {

    NetWorkChangeReceiver netChangeReceiver;
    LocalReceiver localReceiver;

    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_demo);

        registerForBroadcast();
    }

    public void testMyBroadcast(View view) {
        sendBroadcast(new Intent("com.example.androiddemo.broadcast.jjtest"));
    }

    public void testLocalBroadcast(View view) {
        localBroadcastManager.sendBroadcast(new Intent("com.example.androiddemo.broadcast.jjtestlocal"));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(netChangeReceiver);
        localBroadcastManager.unregisterReceiver(localReceiver);
    }

    void registerForBroadcast() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        netChangeReceiver = new NetWorkChangeReceiver();
        registerReceiver(netChangeReceiver, intentFilter);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.androiddemo.broadcast.jjtestlocal");
        localReceiver = new LocalReceiver();
        localBroadcastManager.registerReceiver(localReceiver, intentFilter);
    }

    class NetWorkChangeReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {

            ConnectivityManager netService = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo info = netService.getActiveNetworkInfo();
            if (info != null && info.isAvailable()) {
                Toast.makeText(BroadcastDemoActivity.this, "net is available", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(BroadcastDemoActivity.this, "net is unavailable",
                        Toast.LENGTH_LONG).show();
            }
        }
    }

    class LocalReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "local receiver", Toast.LENGTH_SHORT).show();
        }
    }
}
