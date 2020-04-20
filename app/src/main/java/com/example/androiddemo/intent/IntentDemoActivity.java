package com.example.androiddemo.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.androiddemo.R;

public class IntentDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_demo);

        Intent t = getIntent();
        String msg = t.getStringExtra("msg");
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(msg);
    }

    public void actionForBack(View view) {

        Intent i = new Intent();
        i.putExtra("msg", "hello main");
        setResult(RESULT_OK, i);
        finish();
    }

    @Override
    public void finish() {
        super.finish();
//        Intent i = new Intent();
//        i.putExtra("msg", "hello main");
//        setResult(RESULT_OK, i);

    }
}
