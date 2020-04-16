package com.example.androiddemo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.androiddemo.web.JJWebViewTest;
import com.example.androiddemo.layout.LayoutDemo;
import com.example.androiddemo.widget.WidgetDemo;

//打包密钥生成：https://www.jianshu.com/p/aae17a5e9e59

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View fl = findViewById(R.id.layout);
        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoLayoutDemoTest();
            }
        });


    }
    private static final String TAG = "MainActivity";

    private void gotoLayoutDemoTest() {
        startActivity(new Intent(MainActivity.this, LayoutDemo.class));
    }

    public  void openWidgetDemo(View sender) {
        startActivity(new Intent(MainActivity.this, WidgetDemo.class));
    }

    public  void openWebView(View sender) {
        startActivity(new Intent(MainActivity.this, JJWebViewTest.class));
    }

    public void testInXmlAction(View sender) {
        Log.d(TAG,"test");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    }
}
