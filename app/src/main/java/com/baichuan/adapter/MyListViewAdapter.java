package com.baichuan.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.baichuan.apptest.R;

import java.util.List;
import java.util.Map;

public class MyListViewAdapter extends BaseAdapter {
    //Map列表，一个Map保存一个列表项数据
    private List<? extends Map<String, ?>> mData;
    //列表项对应布局文件的id号
    private int mItemId;
    //Map列表数据对应的键值（即通过键值访问数据）
    private String[] mKey;
    //列表项布局中各个控件的id号
    private int[] mResId;
    //列表项布局
    private LayoutInflater mItemLayout;

    /**
     * 构造方法
     *
     * @param context 应用程序上下文
     * @param data Map列表，一个Map保存一个列表项数据
     * @param itemId 列表项对应布局文件的id号
     * @param key Map列表数据对应的键值（即通过键值访问数据）
     * @param resId 列表项布局中各个控件的id号
     */
    public MyListViewAdapter(Context context, List<? extends Map<String, ?>> data,
                             int itemId, String[] key, int[] resId) {
        mData = data;
        mItemId = itemId;
        mKey = key;
        mResId = resId;
        mItemLayout = LayoutInflater.from(context);
    }

    /**
     * 获取列表项数据条数
     */
    @Override
    public int getCount() {
        return mData.size();
    }

    /**
     * 获取对应位置的列表项数据
     */
    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    /**
     * 返回对应列表项的位置
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 用于保存findViewById得到的View控件的引用
     */
    private class ViewHolder {
        SparseArray<View> mViews;

        public ViewHolder() {
            mViews = new SparseArray<View>();
        }

        /**
         * 保存view引用
         * @param resId view对应的id号
         * @param view view引用
         */
        public void put(int resId, View view) {
            mViews.put(resId, view);
        }

        /**
         * 根据view的id号获得view引用
         * @param resId view的id号
         */
        public View get(int resId) {
            return mViews.get(resId);
        }
    }

    /**
     * 获取一个列表项对应的view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //获取对应位置的列表项数据
        final Map dataSet = mData.get(position);

        ViewHolder holder = null;
        final String[] key = mKey;
        final int[] resId = mResId;
        //获取列表项布局控件总数
        final int count = resId.length;

        //如果未缓存布局
        if (convertView == null) {
            //加载列表项布局
            convertView = mItemLayout.inflate(R.layout.item_listview2, null);

            holder = new ViewHolder();
            for (int i = 0; i < count; i++) {
                //把列表项布局的控件加入holder
                holder.put(resId[i], convertView.findViewById(resId[i]));
            }
            //保存holder
            convertView.setTag(holder);
        } else {  //如果已经缓存布局，直接取出holder
            holder = (ViewHolder) convertView.getTag();
        }

        for (int i = 0; i < count; i++) {
            //获取对应键值的数据
            final Object data = dataSet.get(key[i]);
            //获取对应资源id的控件
            View v = holder.get(resId[i]);

            if (v instanceof CheckBox) {  //设置CheckBox选中状态
                CheckBox cb = (CheckBox) v;
                cb.setChecked((Boolean) data);

                final int pos = position;
                final int j = i;
                cb.setOnClickListener(new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //获取当前CheckBox的状态
                        boolean state = (Boolean) mData.get(pos).get(key[j]);
                        //删除原来CheckBox的状态
                        dataSet.remove(key[j]);
                        //把CheckBox的状态设置为当前状态取反
                        dataSet.put(key[j], !state);
                    }
                });
            } else if (v instanceof TextView) {  //设置TextView文本
                ((TextView) v).setText(data.toString());
            } else if(v instanceof ImageView) {  //设置ImageView图像
                ((ImageView) v).setImageResource((Integer) data);
            }
        }

        return convertView;
    }
}