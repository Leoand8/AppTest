package com.baichuan.apptest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2016/4/7.
 */
public class HandlerLooperActivity extends AppCompatActivity {

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            System.out.println("UI------->" + Thread.currentThread());
        }
    };

    class MyThread extends Thread {
        public Handler handler;

        @Override
        public void run() {
            Looper.prepare();
            handler = new Handler() {
                @Override
                public void handleMessage(Message msg) {
                    System.out.println("currentThread:" + Thread.currentThread());
                }
            };
            Looper.loop();
        }
    }

    private MyThread thread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handlerlooper);

        //默认整个应用程序是通过ActivityThread进行创建，默认创建一个线程main，线程中默认创建一个Looper，创建Looper过程中会创建一个MessageQueue
        thread = new MyThread();
        thread.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.handler.sendEmptyMessage(1);
        handler.sendEmptyMessage(1);
    }

}
