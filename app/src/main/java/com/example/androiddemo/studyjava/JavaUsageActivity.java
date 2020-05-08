package com.example.androiddemo.studyjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.androiddemo.R;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class JavaUsageActivity<Person> extends AppCompatActivity {

    private static final String TAG = "JavaUsageActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_java_usage);

        //
        Request<Person> request = new Request<Person>() {
            @Override
            public void onSuccess() {
                super.onSuccess();
            }

            @Override
            public void onFail() {
                super.onFail();
            }
        };
        request.test();
    }
}

interface RequestCallBack {

    public void onSuccess();
    public void onFail();
}

//获取泛型类型
abstract class Request<T> implements RequestCallBack {

    void test() {
        Class<? extends Request> aClass = getClass();
        Type superclass = aClass.getGenericSuperclass();
        if (superclass instanceof Class) {
            throw new RuntimeException("Missing type parameter.");
        }
        ParameterizedType parameterized = (ParameterizedType)superclass;
        Type type = parameterized.getActualTypeArguments()[0];
        Log.d("Dog", type.toString());
    }

    @Override
    public void onSuccess() {

    }

    @Override
    public void onFail() {

    }
}