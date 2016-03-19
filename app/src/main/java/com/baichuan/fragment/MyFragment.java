package com.baichuan.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baichuan.apptest.R;

/**
 * Created by Administrator on 2016/3/18.
 */
public class MyFragment extends Fragment {

    private String aaa;

    public String getAaa() {
        return aaa;
    }

    public void setAaa(String aaa) {
        this.aaa = aaa;
    }

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
        Button button = (Button) view.findViewById(R.id.fragmentButton);
        textView.setText("静态加载Fragment");
        button.setText("获取内容");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value = getAaa();
                Toast.makeText(getActivity(), "value=" + value, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
//        return super.onCreateView(inflater, container, savedInstanceState);
    }
}
