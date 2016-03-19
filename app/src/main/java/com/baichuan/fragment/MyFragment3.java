package com.baichuan.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baichuan.apptest.R;

/**
 * 启动Fragment → 屏幕锁屏 → 屏幕解锁 → 切换到其他的Fragment → 回到桌面 → 再回到应用
 * Created by Administrator on 2016/3/18.
 */
public class MyFragment3 extends Fragment {

    private TextView tv;
    String TAG = "MyFragment3";

    //每次创建都会绘制Fragment的View组件时回调该方法
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        TextView tv = (TextView) view.findViewById(R.id.fragment2_text);
        tv.setText("第一个Fragment");
        Log.i(TAG, "onCreateView: MyFragment3");
        return view;
    }

    //当Fragment被添加到activity时候会回调这个方法，且只被调用一次
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: MyFragment3");
    }

    //创建Fragment时会回调，只被调用一次
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: MyFragment3");
    }

    //当Fragment所在的Activity启动完成后调用
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: MyFragment3");
    }

    //启动Fragment
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: MyFragment3");
    }

    //恢复Fragment时会被回调，调用onStart()方法后面一定会调用onResume()方法
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: MyFragment3");
    }

    //暂停Fragment
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: MyFragment3");
    }

    //停止Fragment
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: MyFragment3");
    }

    //销毁Fragment所包含的View组件时调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: MyFragment3");
    }

    //销毁Fragment时会被回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: MyFragment3");
    }

    //Fragment从Activity中删除时会回调该方法，且只被回调一次
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: MyFragment3");
    }
}
