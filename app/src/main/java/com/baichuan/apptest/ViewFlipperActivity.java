package com.baichuan.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

/**
 * Created by Administrator on 2016/3/21.
 */
public class ViewFlipperActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    private int[] resId = {
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4};
    private float startX;
    private float endX;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewflipper);

        flipper = (ViewFlipper) findViewById(R.id.flipper);
        //动态导入的方式为ViewFlipper加入子View
        for (int i = 0; i < resId.length; ++i) {
            flipper.addView(getImageView(resId[i]));
        }
        //为ViewFlipper去添加动画效果
//        flipper.setInAnimation(this, R.anim.left_in);
//        flipper.setOutAnimation(this, R.anim.left_out);
//        //设定ViewFlipper视图切换的时间间隔
//        flipper.setFlipInterval(3000);
//        flipper.startFlipping();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            //手指按下
            case MotionEvent.ACTION_DOWN: {
                //获得起始点坐标
                startX = event.getX();
                break;
            }
            //手指滑动
            case MotionEvent.ACTION_MOVE: {
                //获得终点坐标
                endX=event.getX();
                break;
            }
            //手指离开
            case MotionEvent.ACTION_UP: {
                //若向右滑动看前一页
                if (endX-startX>100){
                    flipper.setInAnimation(this, R.anim.left_in);
                    flipper.setOutAnimation(this, R.anim.left_out);
                    flipper.showPrevious();//显示前一页
                }
                //若向左滑动看后一页
                if (startX - endX > 100){
                    flipper.setInAnimation(this, R.anim.right_in);
                    flipper.setOutAnimation(this, R.anim.right_out);
                    flipper.showNext();//显示后一页
                }
                break;
            }
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(this);
        image.setBackgroundResource(resId);
        return image;
    }
}
