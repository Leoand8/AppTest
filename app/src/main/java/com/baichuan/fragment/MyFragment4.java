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
 * Created by Administrator on 2016/3/18.
 */
public class MyFragment4 extends Fragment {

    private TextView tv;
    String TAG = "MyFragment4";

    //每次创建都会绘制Fragment的View组件时回调该方法
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2, container, false);
        TextView tv = (TextView) view.findViewById(R.id.fragment2_text);
        tv.setText("第二个Fragment");
        Log.i(TAG, "onCreateView: MyFragment4");
        return view;
    }

    //当Fragment被添加到activity时候会回调这个方法，且只被调用一次
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: MyFragment4");
    }

    //创建Fragment时会回调，只被调用一次
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: MyFragment4");
    }

    //当Fragment所在的Activity启动完成后调用
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: MyFragment4");
    }

    //启动Fragment
    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: MyFragment4");
    }

    //恢复Fragment时会被回调，调用onStart()方法后面一定会调用onResume()方法
    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: MyFragment4");
    }

    //暂停Fragment
    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: MyFragment4");
    }

    //停止Fragment
    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: MyFragment4");
    }

    //销毁Fragment所包含的View组件时调用
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "onDestroyView: MyFragment4");
    }

    //销毁Fragment时会被回调
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: MyFragment4");
    }

    //Fragment从Activity中删除时会回调该方法，且只被回调一次
    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: MyFragment4");
    }
}
