package com.baichuan.otherclass;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Administrator on 2016/3/25.
 */
public class MyAsyncTask extends AsyncTask<String, Integer, Bitmap> {
    final static String TAG = "MyAsyncTask";

    private ImageView mImageView;
    private ProgressBar mProgressBar;
    private TextView mTextView;

    public MyAsyncTask(ImageView image, ProgressBar progressbar, TextView textView) {
        mImageView = image;
        mProgressBar = progressbar;
        mTextView = textView;
    }

    //第2步，下载网络数据（耗时操作）
    @Override
    protected Bitmap doInBackground(String... params) {
        Log.i(TAG, "doInBackground: ");
        //获取传递进来的参数，只有一个参数所以传入0即可
        String url = params[0];
        Bitmap bitmap = null;
        URLConnection connection;
        InputStream is;
        try {
            connection = new URL(url).openConnection();
            is = connection.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            //模拟进度更新
            for (int i = 0; i <= 100; i++) {
                if (isCancelled()) {
                    //如果被取消则跳出for循环
                    break;
                }
                publishProgress(i);
                Thread.sleep(100);//为观察progressBar效果延缓时间，可删除
            }
            //通过decodeStream方法解析输入流从而转化为一张Bitmap
            bitmap = BitmapFactory.decodeStream(bis);
            is.close();
            bis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //将Bitmap作为返回值返回给后面调用的方法
        return bitmap;
    }

    //第1步，加载进度条
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.i(TAG, "onPreExecute: ");
        mProgressBar.setVisibility(View.VISIBLE);
        mTextView.setVisibility(View.VISIBLE);
    }

    //第4步，隐藏进度条并显示图片
    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        Log.i(TAG, "onPostExecute: ");
        mProgressBar.setVisibility(View.GONE);
        mTextView.setVisibility(View.GONE);
        mImageView.setImageBitmap(bitmap);
    }

    //如果从doInBackground中调用则为3
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        Log.i(TAG, "onProgressUpdate: ");
        if (isCancelled()) {
            //如果被取消则停止更新
            return;
        }
        //获取进度更新值
        mProgressBar.setProgress(values[0]);
        mTextView.setText(values[0].toString() + "%");
    }
}
