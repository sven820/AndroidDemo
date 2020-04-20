package com.example.androiddemo.widget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.androiddemo.R;

public class WidgetDemo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_demo);
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
}
