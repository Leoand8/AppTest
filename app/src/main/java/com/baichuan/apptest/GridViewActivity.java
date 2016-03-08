package com.baichuan.apptest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/7.
 */
public class GridViewActivity extends Activity implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private int[] icon = {
            R.drawable.clock,
            R.drawable.logo,
            R.drawable.mail,
            R.drawable.message,
            R.drawable.monkey,
            R.drawable.qq,
            R.drawable.qzone,
            R.drawable.sina,
            R.drawable.tencent,
            R.drawable.friends,
            R.drawable.wandoujia,
            R.drawable.weixin};
    private String[] iconName = {"时钟", "猿题库", "邮件", "信息", "猴子", "QQ", "QQ空间", "新浪", "腾讯", "朋友圈", "豌豆荚", "微信"};
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);

        gridView = (GridView) findViewById(R.id.gridview);

        //1、准备数据源（数据源是特殊泛型的集合）
        //2、新建适配器（SimpleAdapter）
        //3、视图界面GridView加载适配器
        //4、给视图界面GridView配置事件监听器（OnItemClickListener）
        dataList = new ArrayList<Map<String, Object>>();
//        getData();
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item_gridview, new String[]{"image", "text"}, new int[]{R.id.img_gridviewitem, R.id.text_gridviewitem});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < icon.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("image", icon[i]);
            map.put("text", iconName[i]);
            dataList.add(map);
        }
        return dataList;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "我是" + iconName[position], Toast.LENGTH_SHORT).show();
    }
}
