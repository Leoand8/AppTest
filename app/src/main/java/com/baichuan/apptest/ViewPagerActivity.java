package com.baichuan.apptest;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

import com.baichuan.adapter.MyPagerAdapter;
import com.baichuan.fragmentViewPager.Fragment1;
import com.baichuan.fragmentViewPager.Fragment2;
import com.baichuan.fragmentViewPager.Fragment3;
import com.baichuan.fragmentViewPager.Fragment4;
import com.baichuan.fragmentViewPager.MyFragmentPagerAdapter;
import com.baichuan.fragmentViewPager.MyFragmentPagerAdapter2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/3/21.
 */
public class ViewPagerActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {
    private List<View> viewList;
    private ViewPager viewPager;
    private PagerTabStrip tab;
    private List<String> titleList;
    private List<Fragment> fragList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);

        viewList = new ArrayList<View>();
        //通过View对象去作为ViewPager的数据源
        View view1 = View.inflate(this, R.layout.view1, null);
        View view2 = View.inflate(this, R.layout.view2, null);
        View view3 = View.inflate(this, R.layout.view3, null);
        View view4 = View.inflate(this, R.layout.view4, null);

        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        viewList.add(view4);

        //通过Fragment作为ViewPager的数据源
        fragList = new ArrayList<Fragment>();
        fragList.add(new Fragment1());
        fragList.add(new Fragment2());
        fragList.add(new Fragment3());
        fragList.add(new Fragment4());

        //为ViewPager页卡设置标题
        titleList = new ArrayList<String>();
        titleList.add("第一页");
        titleList.add("第二页");
        titleList.add("第三页");
        titleList.add("第四页");

        //初始化PagerTabStrip
        tab = (PagerTabStrip) findViewById(R.id.pagertab);
        //为PagerTabStrip设置一些属性
        tab.setBackgroundColor(Color.YELLOW);
        tab.setTextColor(Color.RED);
        tab.setDrawFullUnderline(false);
        tab.setTabIndicatorColor(Color.GREEN);

        //初始化viewPager
        viewPager = (ViewPager) findViewById(R.id.viewpager);

        //创建PagerAdapter的适配器
        MyPagerAdapter adapter = new MyPagerAdapter(viewList, titleList);
        MyFragmentPagerAdapter adapter1 = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragList, titleList);
        MyFragmentPagerAdapter2 adapter2 = new MyFragmentPagerAdapter2(getSupportFragmentManager(), fragList, titleList);
        //ViewPager加载适配器
        viewPager.setAdapter(adapter2);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "当前是第" + (position+1) + "个页面。", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}