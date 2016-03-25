package com.baichuan.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichuan.apptest.R;
import com.baichuan.otherclass.ItemBean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/24.
 */
public class ListView2Adapter extends BaseAdapter {

    //映射数据，
    private List<ItemBean> mList;
    private LayoutInflater mInflater;
    private long mSumTime;

    public ListView2Adapter(Context context, List<ItemBean> list) {
        mList = list;//在构造方法中初始化用于映射的数据List
        mInflater = LayoutInflater.from(context);
    }

    // 获取数据量
    @Override
    public int getCount() {
        return mList.size();
    }

    // 获取对应ID项对应的Item
    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    // 获取对应项ID
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //逗比式
//        long start = System.nanoTime();//获取系统纳秒时间
//        View view = mInflater.inflate(R.layout.item_listview2, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.item2_img);
//        TextView title = (TextView) view.findViewById(R.id.item2_title);
//        TextView content = (TextView) view.findViewById(R.id.item2_content);
//        ItemBean bean = mList.get(position);
//        imageView.setImageResource(bean.ItemImageResid);
//        title.setText(bean.ItemTitle);
//        content.setText(bean.ItemContent);
//        long end = System.nanoTime();
//        long dValue = end - start;
//        mSumTime += dValue;
//        Log.i("time", "逗比式消耗时间：" + String.valueOf(mSumTime));//15140816
//        return view;

        //普通式：利用ListView的缓存convertView
//        long start = System.nanoTime();//获取系统纳秒时间
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.item_listview2, null);
//        }
//        ImageView imageView = (ImageView) convertView.findViewById(R.id.item2_img);
//        TextView title = (TextView) convertView.findViewById(R.id.item2_title);
//        TextView content = (TextView) convertView.findViewById(R.id.item2_content);
//        ItemBean bean = mList.get(position);
//        imageView.setImageResource(bean.ItemImageResid);
//        title.setText(bean.ItemTitle);
//        content.setText(bean.ItemContent);
//        long end = System.nanoTime();
//        long dValue = end - start;
//        mSumTime += dValue;
//        Log.i("time", "普通式消耗时间：" + String.valueOf(mSumTime));//12745206
//        return convertView;

        /**
         * 文艺式：
         * 不仅利用ListView的缓存，
         * 更通过ViewHolder类来实现显示数据的视图的缓存，
         * 避免多次通过findViewById寻找控件
         */
        long start = System.nanoTime();//获取系统纳秒时间
        ViewHolder viewHolder;
        //判断convertView，为空则创建，并设置tag，否则通过tag来取出ViewHolder
        if (convertView == null) {
            viewHolder = new ViewHolder();
            // 由于我们只需要将XML转化为View，并不涉及到具体的布局，所以第二个参数通常设置为null
            convertView = mInflater.inflate(R.layout.item_listview2, null);
            // 实例化控件
            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.item2_img);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item2_title);
            viewHolder.content = (TextView) convertView.findViewById(R.id.item2_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        // 取出bean对象
        ItemBean bean = mList.get(position);
        //给ViewHolder中的控件设置数据
        viewHolder.imageView.setImageResource(bean.ItemImageResid);
        viewHolder.title.setText(bean.ItemTitle);
        viewHolder.content.setText(bean.ItemContent);

        long end = System.nanoTime();
        long dValue = end - start;
        mSumTime += dValue;
        // 输出每次getView消耗的时间和
        Log.i("time", "文艺式消耗时间：" + String.valueOf(mSumTime));//9894128
        return convertView;
    }

    class ViewHolder {
        //创建ViewHolder类，创建布局映射关系
        public ImageView imageView;
        public TextView title;
        public TextView content;
    }
}
