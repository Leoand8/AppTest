package com.baichuan.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Administrator on 2016/4/5.
 */
public class MyBindService extends Service {

    String TAG = "info";

    @Override
    public void onCreate() {
        Log.i(TAG, "onCreate: ");
        super.onCreate();
    }

    public class MyBinder extends Binder {
        public MyBindService getService() {
            return MyBindService.this;
        }
    }


    @Override
    public void onDestroy() {
        Log.i(TAG, "onDestroy: ");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind: ");
        return new MyBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "onUnbind: ");
        return super.onUnbind(intent);
    }

    public void Play() {
        Log.i(TAG, "Play: 播放");
    }

    public void Pause() {
        Log.i(TAG, "Pause: 暂停");
    }

    public void Previous() {
        Log.i(TAG, "Previous: 上一首");
    }

    public void Next() {
        Log.i(TAG, "Next: 下一首");
    }
}
