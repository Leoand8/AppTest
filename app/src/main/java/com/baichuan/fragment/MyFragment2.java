package com.baichuan.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baichuan.apptest.R;

/**
 * Created by Administrator on 2016/3/18.
 */
public class MyFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //layout布局文件转换成View对象
        /**
         * resource:Fragment需要加载的布局文件
         * root:加载layout的父ViewGroup
         * attactToRoot:false,不返回父ViewGroup
         */
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragmentText);
        textView.setText("动态加载Fragment");
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
