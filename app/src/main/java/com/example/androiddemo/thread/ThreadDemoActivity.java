package com.example.androiddemo.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

import com.example.androiddemo.R;

public class ThreadDemoActivity extends AppCompatActivity {

    private static final String TAG = "ThreadDemoActivity";
    private Handler handler = new Handler(Looper.getMainLooper()) {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);

        Looper looper = Looper.myLooper();
        Thread thread = looper.getThread();
        String name = thread.getName();


        testThread();

        runOnUiThread(new Runnable() {
            @Override
            public void run() {

            }
        });

    }

    void runOnMainTest() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Message message = new Message();
                message.what = 1;
//                handler.sendMessage(message);
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }
        }).start();
    }

    void testThread2() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.myLooper();
                Log.d(TAG, Thread.currentThread().toString());
            }
        }).start();
    }

    void testThread() {
        JJThread thread = new JJThread();
        thread.start();
    }

    void testAsyncTask() {
        new MyAsyncTask().execute();
    }

    class JJThread extends Thread {
        @Override
        public void run() {
            super.run();
            Looper.prepare();
            Looper.loop();
            Handler handler2 = new Handler(Looper.myLooper()) {
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                }
            };
            Message obtain = Message.obtain();
            obtain.obj = handler2;
            handler.sendMessage(obtain);
            Log.d(TAG, Looper.myLooper().toString());
            Log.d(TAG, Looper.getMainLooper().toString());
        }
    }

    class MyAsyncTask extends AsyncTask<Void, Integer, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Void... voids) {
//            publishProgress(100);
            return false;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean b) {
            super.onPostExecute(b);

        }
    }
}
