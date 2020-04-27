package com.example.androiddemo.widget;

import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewManager;

import com.example.androiddemo.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class DemoFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_demo);

        View infoBtn = findViewById(R.id.info);
        infoBtn.setOnClickListener(this);

        View detailBtn = findViewById(R.id.detail);
        detailBtn.setOnClickListener(this);

        replaceForDetail(new FamousPeopleInfoFragment());
        Fragment menuFragment= getSupportFragmentManager().findFragmentById(R.id.menu_fragment);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.info:
                replaceForDetail(new FamousPeopleInfoFragment());
                break;
            case R.id.detail:
                replaceForDetail(new FamousPeopleDetailFragment());
                break;
        }
    }

    void replaceForDetail(Fragment fragment) {
        FragmentManager manger = getSupportFragmentManager();
        FragmentTransaction translate = manger.beginTransaction();
        translate.replace(R.id.detail_fragment, fragment);
        translate.addToBackStack(null);
        translate.commit();
    }
}

