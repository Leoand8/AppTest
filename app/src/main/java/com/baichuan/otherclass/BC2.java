package com.baichuan.otherclass;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2016/4/5.
 */
public class BC2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String s = intent.getStringExtra("msg");
        System.out.println("receiver2收到消息：" + s);
        Bundle bundle = getResultExtras(true);
        String s2 = bundle.getString("test");
        System.out.println("得到的处理结果是:" + s2);
//        abortBroadcast();//会出错，说明普通广播是不能被截断的。
    }
}
