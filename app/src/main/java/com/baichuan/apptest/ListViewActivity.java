package com.baichuan.apptest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/1.
 */
public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener,AbsListView.OnScrollListener{

    private android.widget.ListView listView;
    private ArrayAdapter<String> arrayAdapter;//适配器
    private SimpleAdapter simpleAdapter;//适配器
    private List<Map<String, Object>> datalist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        listView = (android.widget.ListView) findViewById(R.id.listView);
        /**
         * 数组Adapter
         * 1、新建一个适配器
         * 2、适配器加载数据源
         * 3、用视图加载适配器
         */
        //数据源
        String[] arr_data = {"1", "2", "3", "4"};
        //ArrayAdapter（上下文，当前ListView加载的每一个列表项所对应的布局文件，数据源）
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr_data);
        //视图就是ListView
//        listView.setAdapter(arrayAdapter);
        /**
         * SimpleAdapter
         */
        datalist = new ArrayList<Map<String, Object>>();
        //SimpleAdapter
        // context:上下文
        // data:数据源，(List<? extends Map<String, ?>> data)一个Map所组成的List集合
        //      每一个Map都会对应ListView列表中的一行
        //      每一个Map（键-值对）中的键key必须包含所有在from中所指定的键
        // resource:列表项布局文件ID
        // from:Map中的键名
        // to:绑定数据视图中的ID，与from对应
        simpleAdapter = new SimpleAdapter(this, getData(), R.layout.item_listview, new String[]{"img", "text"}, new int[]{R.id.item_img, R.id.item_text});
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(this);
        listView.setOnScrollListener(this);
    }

    private List<Map<String, Object>> getData() {
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", R.mipmap.ic_launcher);
            map.put("text", "Text" + i);
            datalist.add(map);
        }
        return datalist;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text = listView.getItemAtPosition(position)+"";
        Toast.makeText(this,"position:"+position+" text:"+text,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        switch (scrollState){
            case SCROLL_STATE_TOUCH_SCROLL:
                Log.i("ListViewActivity","视图正在滑动，手指没有离开屏幕");
                break;
            case SCROLL_STATE_FLING:
                Log.i("ListViewActivity","用户在手指离开屏幕之前，由于用力划了一下，视图仍靠惯性继续滑动，手指已经离开屏幕");
                Map<String,Object> map = new HashMap<String, Object>();
                map.put("img",R.drawable.orange_bg);
                map.put("text","orange");
                datalist.add(map);
                simpleAdapter.notifyDataSetChanged();
                break;
            case SCROLL_STATE_IDLE:
                Log.i("ListViewActivity","空闲，视图已经停止滑动");
                break;
            default:
                break;
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }
}
