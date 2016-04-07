package com.baichuan.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/7.
 */
public class GestureDetectorActivity extends AppCompatActivity {

    ImageView imageView;
    GestureDetector mGestureDetector;

    class myGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e1.getX() - e2.getX() > 50) {
                Toast.makeText(GestureDetectorActivity.this, "从右往左滑动", Toast.LENGTH_LONG).show();
            } else if (e2.getX() - e1.getX() > 50) {
                Toast.makeText(GestureDetectorActivity.this, "从左往右滑动", Toast.LENGTH_LONG).show();
            }
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesturedetector);
        imageView = (ImageView) findViewById(R.id.gesturedetector_img);
        imageView.setLongClickable(true);
        mGestureDetector = new GestureDetector(GestureDetectorActivity.this, new myGestureListener());
        imageView.setOnTouchListener(new View.OnTouchListener() {
            //捕获触屏事件
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mGestureDetector.onTouchEvent(event);
                return false;
            }
        });
    }
}
