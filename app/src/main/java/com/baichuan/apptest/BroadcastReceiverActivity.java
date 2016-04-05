package com.baichuan.apptest;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.baichuan.otherclass.BC2;
import com.baichuan.otherclass.BC3;

/**
 * Created by Administrator on 2016/3/31.
 */
public class BroadcastReceiverActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcastreceiver);
        IntentFilter intentFilter = new IntentFilter("com.baichuan.apptest.BroadcastReceiverActivity");
        BC2 bc2 = new BC2();
        registerReceiver(bc2, intentFilter);
    }

    public void doClick(View v) {
        switch (v.getId()) {
            //发送一条普通广播
            case R.id.broadcastReceiver_send1:
                Intent intent = new Intent();
                intent.putExtra("msg", "这是一条普通广播");
                intent.setAction("com.baichuan.apptest.BroadcastReceiverActivity");
                sendBroadcast(intent);
                break;
            case R.id.broadcastReceiver_send2:
                Intent intent2 = new Intent();
                intent2.putExtra("msg", "这是一条有序广播");
                intent2.setAction("com.baichuan.apptest.BroadcastReceiverActivity");
                sendOrderedBroadcast(intent2, null);
                break;
            case R.id.broadcastReceiver_send3:
                Intent intent3 = new Intent();
                intent3.putExtra("msg", "这是一条异步广播");
                intent3.setAction("com.baichuan.apptest.BroadcastReceiverActivity3");
                sendStickyBroadcast(intent3);
                IntentFilter intentFilter = new IntentFilter("com.baichuan.apptest.BroadcastReceiverActivity3");
                BC3 bc3 = new BC3();
                registerReceiver(bc3, intentFilter);

                break;
        }
    }
}
