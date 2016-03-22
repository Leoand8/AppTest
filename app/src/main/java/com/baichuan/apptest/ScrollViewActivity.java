package com.baichuan.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/3/22.
 */
public class ScrollViewActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textView;
    private ScrollView scrollView;
    private Button up_btn;
    private Button down_btn;
    private String TAG = "ScrollView";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrollview);

        textView = (TextView) findViewById(R.id.scrollView_textcontent);
        up_btn = (Button) findViewById(R.id.scrollViewUp);
        down_btn = (Button) findViewById(R.id.scrollViewDown);

//        textView.setText(getResources().getString(R.string.content));
        textView.setText(R.string.content);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        scrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN: {
                        break;
                    }
                    case MotionEvent.ACTION_MOVE: {
                        break;
                    }
                    case MotionEvent.ACTION_UP: {
                        /**
                         * 三个方法：
                         * 一：getScrollY()滚动条滑动的距离，从0开始计算
                         * 二：getMeasuredHeight()若超过显示则高度为总高度
                         * 三：getHeight高度不变
                         */
                        //顶部状态
                        if (scrollView.getScrollY() <= 0) {
                            Log.i(TAG, "onTouch: 滑动到顶部");
                        }
                        //底部状态
                        //TextView的总高度<=一屏幕的高度+滚动条的滚动距离
                        if (scrollView.getChildAt(0).getMeasuredHeight() <= scrollView.getHeight() + scrollView.getScrollY()) {
                            Log.i(TAG, "onTouch: 滑动到底部");
                            Log.i(TAG,
                                    "scrollView.getChildAt(0).getMeasuredHeight()="
                                            + scrollView.getChildAt(0).getMeasuredHeight()
                                            + " scrollView.getHeight()="
                                            + scrollView.getHeight()
                                            + " scrollView.getScrollY()="
                                            + scrollView.getScrollY());
                            textView.append("\nAndroid");
                        }
                        break;
                    }
                    default:
                        break;
                }
                return false;
            }
        });

        up_btn.setOnClickListener(this);
        down_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            //scrollTo:以起始位置开始计算
            //scrollBy:以前一个位置开始计算
            case R.id.scrollViewUp: {
                scrollView.scrollBy(0, -30);
                break;
            }
            case R.id.scrollViewDown: {
                scrollView.scrollBy(0, 30);
                break;
            }
        }
    }
}
