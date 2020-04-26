package com.example.androiddemo.widget;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.androiddemo.R;
import com.example.androiddemo.widget.ListViewActivityDemo;

public class WidgetDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_demo);

        ImageView imgV = findViewById(R.id.imgView);
        imgV.setImageResource(R.mipmap.jxf_test);

        ActionBar bar = getSupportActionBar();
        if (bar != null) {
            bar.hide();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Toast.makeText(this, "add sucess", Toast.LENGTH_LONG).show();
            case R.id.remove:
                Toast.makeText(this, "remove sucess", Toast.LENGTH_LONG).show();

        }
        return true;
    }

    public void onClickToast(View view) {

        Toast.makeText(WidgetDemo.this, "hello", Toast.LENGTH_SHORT).show();
//        Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show();
    }

    public void onClickBack(View view) {
        this.finish();
    }

    public void onClickBackTestDialog(View view) {
        AlertDialog.Builder log = new AlertDialog.Builder(this);
        log.setTitle("jxf");
        log.setMessage("hello");
        log.setCancelable(true);
        log.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WidgetDemo.this, "YES", Toast.LENGTH_SHORT).show();
            }
        });
        log.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(WidgetDemo.this, "NO", Toast.LENGTH_SHORT).show();
            }
        });

        log.show();

    }
    public void onClickTestListView(View view) {
        startActivity(new Intent(this, ListViewActivityDemo.class));
    }
}
