package com.baichuan.apptest;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/7.
 */
public class HandlerActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ImageView imageView;
    private Button button;
    private android.os.Handler handler1 = new android.os.Handler();
    private int images[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
    private int index;
    private MyRunnable myRunnable = new MyRunnable();
    private Handler handler2 = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), "" + 1, Toast.LENGTH_SHORT).show();
            return false;
        }
    }) {
        @Override
        public void handleMessage(Message msg) {
            textView2.setText("arg1:" + msg.arg1 + " arg2:" + msg.arg2);
            textView3.setText("" + msg.obj);
            Toast.makeText(getApplicationContext(), "" + 2, Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public void onClick(View v) {
        handler1.removeCallbacks(myRunnable);
        handler2.sendEmptyMessage(1);
    }

    class Person {
        public int age;
        public String name;

        public String toString() {
            return "name=" + name + " age=" + age;
        }
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            index++;
            index = index % 4;
            imageView.setImageResource(images[index]);
            handler1.postDelayed(myRunnable, 1000);//每秒播放一张
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        textView1 = (TextView) findViewById(R.id.handler_text1);
        textView2 = (TextView) findViewById(R.id.handler_text2);
        textView3 = (TextView) findViewById(R.id.handler_text3);
        imageView = (ImageView) findViewById(R.id.handler_image);
        button = (Button) findViewById(R.id.handler_btn);
        button.setOnClickListener(this);

        handler1.postDelayed(myRunnable, 1000);//1秒后执行myRunnable中的run方法

        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    //handler用法之post(Runnable)
                    handler1.post(new Runnable() {
                        @Override
                        public void run() {
                            textView1.setText("用Handler轮播图片");
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(2000);
                    //handler用法之sendMessage
//                    Message message = new Message();可以创建对象也可以从Handler中取
                    Message message = handler2.obtainMessage();
                    message.arg1 = 88;
                    message.arg2 = 100;
                    Person person = new Person();
                    person.age = 23;
                    person.name = "nate";
                    message.obj = person;
//                    handler2.sendMessage(message);也可以用sendToTarget
                    message.sendToTarget();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
