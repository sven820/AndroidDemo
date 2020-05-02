package com.example.androiddemo.web;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import com.example.androiddemo.R;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class JJWebViewTest extends AppCompatActivity {

    private static final String TAG = "JJWebViewTest";
    private WebView webView;
    OkHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_j_web_view_test);

        client = new OkHttpClient();
    }

    public void onClickForWebView(View view) {
        //系统浏览器
        Intent t = new Intent(Intent.ACTION_VIEW);
        t.setData(Uri.parse("https://www.baidu.com"));
        startActivity(t);
    }

    public void onClickForGetRequest(View view) {
        Request request =
                new Request.Builder().url("https://www.baidu.com").method("GET", null).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Log.e(TAG, e.getMessage());
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String string = response.body().string();
                Log.d(TAG, string);
            }
        });
    }

    public void onClickForPostRequest(View view) {

    }
}
