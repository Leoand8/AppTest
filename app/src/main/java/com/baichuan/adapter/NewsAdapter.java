package com.baichuan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichuan.apptest.R;
import com.baichuan.otherclass.ImageLoader;
import com.baichuan.otherclass.NewsBean;

import java.util.List;

/**
 * Created by Administrator on 2016/3/26.
 */
public class NewsAdapter extends BaseAdapter {

    private List<NewsBean> mList;
    private LayoutInflater mInflater;

    public NewsAdapter(Context context, List<NewsBean> data) {
        mList = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_news, null);
            viewHolder.ivIcon = (ImageView) convertView.findViewById(R.id.news_image);
            viewHolder.tvTitle = (TextView) convertView.findViewById(R.id.news_title);
            viewHolder.tvContent = (TextView) convertView.findViewById(R.id.news_content);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.ivIcon.setImageResource(R.mipmap.ic_launcher);//显示默认图片
        //显示网络图片
        String url = mList.get(position).newsIconUrl;
        viewHolder.ivIcon.setTag(url);

//        new ImageLoader().showImageByThread(viewHolder.ivIcon, url);
        new ImageLoader().showImageByAsyncTask(viewHolder.ivIcon, url);

        viewHolder.tvTitle.setText(mList.get(position).newsTitle);
        viewHolder.tvContent.setText(mList.get(position).newsContent);

        return convertView;
    }

    class ViewHolder {
        public TextView tvTitle, tvContent;
        public ImageView ivIcon;
    }

}
