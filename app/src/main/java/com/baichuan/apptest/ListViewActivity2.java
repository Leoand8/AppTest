package com.baichuan.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.baichuan.adapter.MyListViewAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/3/24.
 */
public class ListViewActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview2);

//        List<ItemBean> itemBeenList = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            itemBeenList.add(new ItemBean(
//                    R.mipmap.ic_launcher,
//                    "我是标题" + i,
//                    "我是内容" + i
//            ));
//        }
//        ListView listView = (ListView) findViewById(R.id.listView2);
//        listView.setAdapter(new ListView2Adapter(this, itemBeenList));

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < 20; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", R.mipmap.ic_launcher);
            map.put("title", "标题" + i);
            map.put("content", "内容" + i);
            map.put("checkbox", false);
            list.add(map);
        }
        ListView listView = (ListView) findViewById(R.id.listView2);
        MyListViewAdapter adapter = new MyListViewAdapter(this, list, R.layout.item_mylistview,
                new String[]{"img", "title", "content", "checkbox"},
                new int[]{R.id.item_mlist_img, R.id.item_mlist_title, R.id.item_mlist_content, R.id.item_mlist_checkbox}
        );
        listView.setAdapter(adapter);
    }
}
