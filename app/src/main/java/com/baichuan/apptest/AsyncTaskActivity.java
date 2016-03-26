package com.baichuan.apptest;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.baichuan.otherclass.MyAsyncTask;

/**
 * Created by Administrator on 2016/3/25.
 */
public class AsyncTaskActivity extends AppCompatActivity {

    private MyAsyncTask mTask;
    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private TextView mTextView;
    private static String URL = "http://img.my.csdn.net/uploads/201504/12/1428806103_9476.png";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);

        mImageView = (ImageView) findViewById(R.id.async_image);
        mProgressBar = (ProgressBar) findViewById(R.id.async_progressbar);
        mTextView = (TextView) findViewById(R.id.async_progressText);

        mTask = new MyAsyncTask(mImageView, mProgressBar, mTextView);
        mTask.execute(URL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            //cancel方法只是将对应的asyncTask标记为cancel状态，并不是真正的取消线程的执行
            //而且我们在Java中也是没办法直接粗暴地停止一个线程的
            //我们必须要等一个线程执行完毕之后才能够做后面的操作
            mTask.cancel(true);
        }
    }
}
