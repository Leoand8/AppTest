package com.baichuan.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.baichuan.apptest.R;

/**
 * Created by Administrator on 2016/3/18.
 */
public class FragmentActivity3 extends AppCompatActivity {

    private Button button;
    private Fragment frag;
    private boolean flag = true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment3);
        init();
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
                if (flag) {
                    MyFragment4 frag4=new MyFragment4();
                    beginTransaction.replace(R.id.layout, frag4);
                    flag = false;
                }else {
                    MyFragment3 frag3 = new MyFragment3();
                    beginTransaction.replace(R.id.layout, frag3);
                    flag = true;
                }
                beginTransaction.commit();
            }
        });
    }

    private void init() {
        FragmentManager fragmentManager=getFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        MyFragment3 frag3 = new MyFragment3();
        beginTransaction.add(R.id.layout, frag3);
        beginTransaction.commit();
    }
}
