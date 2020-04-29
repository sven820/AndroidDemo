package com.example.androiddemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androiddemo.broadcast.BroadcastDemoActivity;
import com.example.androiddemo.store.StoreActivity;
import com.example.androiddemo.web.JJWebViewTest;
import com.example.androiddemo.layout.LayoutDemo;
import com.example.androiddemo.widget.WidgetDemo;
import com.example.androiddemo.intent.IntentDemoActivity;

//打包密钥生成：https://www.jianshu.com/p/aae17a5e9e59

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setTitle("main");

        textView = findViewById(R.id.textView);
        View fl = findViewById(R.id.layout);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoLayoutDemoTest();
            }
        });

        if (savedInstanceState != null) { //持久化数据恢复
            textView.setText(savedInstanceState.getString("msg"));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);

        String msg = (String) textView.getText();
        outState.putString("msg", msg);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void gotoLayoutDemoTest() {
        startActivity(new Intent(MainActivity.this, LayoutDemo.class));
    }

    public  void openWidgetDemo(View sender) {
        startActivity(new Intent(MainActivity.this, WidgetDemo.class));
    }

    public  void openWebView(View sender) {
//        startActivity(new Intent(MainActivity.this, JJWebViewTest.class));
        //系统浏览器
        Intent t = new Intent(Intent.ACTION_VIEW);
        t.setData(Uri.parse("https://www.baidu.com"));
        startActivity(t);
    }

    public void testInXmlAction(View sender) {
        Log.d(TAG,"test");
    }

    public void openIntentDemo(View view) {
        Intent t = new Intent(this, IntentDemoActivity.class);
        t.putExtra("msg", "hello");
        startActivityForResult(t, 1);
//        startActivity(new Intent("com.example.androiddemo.IntentDemoActivity.test"));
    }

    public void openBroadcastDemo(View view) {
        startActivity(new Intent(this, BroadcastDemoActivity.class));
    }

    public void openStoreDemo(View view) {
        startActivity(new Intent(this, StoreActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String msg = data.getStringExtra("msg");
                    textView.setText(msg);
                    Log.v(TAG,Thread.currentThread().toString());
                    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                }
        }
    }
}
