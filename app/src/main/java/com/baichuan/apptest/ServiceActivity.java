package com.baichuan.apptest;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.baichuan.service.MyBindService;
import com.baichuan.service.MyStartService;

/**
 * Created by Administrator on 2016/4/5.
 */
public class ServiceActivity extends AppCompatActivity {

    int tag=0;//给绑定服务设置标签，为1则已开启绑定服务，为0则未开启或已关闭绑定服务
    Intent intent;
    Intent intent_bind;
    MyBindService service;
    ServiceConnection coon = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            service = ((MyBindService.MyBinder) binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
    }

    public void doClick(View v) {
        switch (v.getId()) {
            case R.id.service_start:
                intent = new Intent(ServiceActivity.this, MyStartService.class);
                startService(intent);
                break;
            case R.id.service_stop:
                stopService(intent);
                break;
            case R.id.service_bind:
                tag=1;//开启绑定设置标签为1
                intent_bind = new Intent(ServiceActivity.this, MyBindService.class);
                bindService(intent_bind, coon, Service.BIND_AUTO_CREATE);
                break;
            case R.id.service_play:
                service.Play();
                break;
            case R.id.service_pause:
                service.Pause();
                break;
            case R.id.service_next:
                service.Next();
                break;
            case R.id.service_previous:
                service.Previous();
                break;
            case R.id.service_unbind:
                tag=0;//关闭绑定设置标签为0
                unbindService(coon);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        //当标签为1时退出，则关闭绑定，防止报错。
        if (tag == 1) {
            unbindService(coon);
        }
        super.onDestroy();
    }
}
