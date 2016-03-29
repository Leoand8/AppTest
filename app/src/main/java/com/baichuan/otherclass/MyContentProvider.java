package com.baichuan.otherclass;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.Nullable;

/**
 * Uri是指通用资源标识符如：
 * content://com.imooc.provider/music/#
 * 前缀表明数据受控于一个内容提供者，从不修改，也就是schema
 * Created by Administrator on 2016/3/29.
 */
public class MyContentProvider extends ContentProvider {

    @Override//在ContentProvider创建后被调用
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override//根据Uri查询出selection指定的条件所匹配的全部记录，并且可以指定查询哪些列，以什么方式(order)排序
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return null;
    }

    //返回当前Uri的MIME类型，如果改Uri对应的数据可能包括多条记录，那么MIME类型字符串就是以vnd.android.dir/开头
    //如果该Uri对应的数据只有一条记录，该MIME类型字符串就是以vnd.android.cursor.item/开头
    @Nullable
    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Nullable
    @Override//根据Uri插入Values对应的数据
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override//根据Uri删除selection指定的条件所匹配的全部记录
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }

    @Override//根据Uri修改selection指定的条件所匹配的全部记录
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return 0;
    }
}
