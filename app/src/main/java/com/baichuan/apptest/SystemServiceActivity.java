package com.baichuan.apptest;

import android.app.ActivityManager;
import android.content.Context;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/4/5.
 */
public class SystemServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_systemservice);
        LayoutInflater inflater = (LayoutInflater) SystemServiceActivity.this.getSystemService(LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.activity_systemservice, null);
        setContentView(view);
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.ss_btn_network:
                if (isNetWorkConnected(SystemServiceActivity.this) == true) {
                    Toast.makeText(SystemServiceActivity.this, "网络已经打开，但不知道是WiFi还是移动网络", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(SystemServiceActivity.this, "网络未连接", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ss_btn_wifi:
                WifiManager wifiManager = (WifiManager) SystemServiceActivity.this.getSystemService(WIFI_SERVICE);
                if (wifiManager.isWifiEnabled()) {
                    wifiManager.setWifiEnabled(false);
                    Toast.makeText(SystemServiceActivity.this, "WIFI已经关闭", Toast.LENGTH_SHORT).show();
                } else {
                    wifiManager.setWifiEnabled(true);
                    Toast.makeText(SystemServiceActivity.this, "WIFI已经开启", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ss_btn_voice:
                AudioManager mAudioManager = (AudioManager) SystemServiceActivity.this.getSystemService(AUDIO_SERVICE);
                int maxVolume = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_SYSTEM);
                int current = mAudioManager.getStreamVolume(AudioManager.STREAM_SYSTEM);
                Toast.makeText(SystemServiceActivity.this, "系统的最大音量是：" + maxVolume + "系统现在的音量是：" + current, Toast.LENGTH_SHORT).show();

                break;
            case R.id.ss_btn_package:
                ActivityManager activityMamager = (ActivityManager) SystemServiceActivity.this.getSystemService(ACTIVITY_SERVICE);
                String packageName = activityMamager.getRunningTasks(1).get(0).topActivity.getPackageName();
                Toast.makeText(SystemServiceActivity.this, "当前运行的activity包名:" + packageName, Toast.LENGTH_SHORT).show();

                break;
        }
    }

    public boolean isNetWorkConnected(Context context) {
        if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context.getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
            if (mNetworkInfo != null) {
                return mNetworkInfo.isAvailable();
            }
        }
        return false;
    }
}
