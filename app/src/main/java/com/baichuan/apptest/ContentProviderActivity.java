package com.baichuan.apptest;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.ContactsContract.Contacts;
import android.provider.ContactsContract.CommonDataKinds.Email;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Administrator on 2016/3/29.
 */
public class ContentProviderActivity extends AppCompatActivity {

    private Button cp_btn_insert;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contentprovider);
        cp_btn_insert = (Button) findViewById(R.id.cp_btn_insert);
        cp_btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentResolver cr = getContentResolver();
                //向联系人中插入一条数据
                ContentValues values = new ContentValues();
                Uri uri = cr.insert(ContactsContract.RawContacts.CONTENT_URI, values);
                Long raw_contact_id = ContentUris.parseId(uri);
                values.clear();
                //插入人名
                values.put(StructuredName.RAW_CONTACT_ID, raw_contact_id);
                values.put(StructuredName.DISPLAY_NAME, "张三三");
                values.put(StructuredName.MIMETYPE, ContactsContract.CommonDataKinds.StructuredName.CONTENT_ITEM_TYPE);
                uri = cr.insert(ContactsContract.Data.CONTENT_URI, values);
                //插入电话信息
                values.clear();
                values.put(Phone.RAW_CONTACT_ID, raw_contact_id);
                values.put(Phone.NUMBER, "13333333333");
                values.put(Phone.MIMETYPE, Phone.CONTENT_ITEM_TYPE);
                uri = cr.insert(ContactsContract.Data.CONTENT_URI, values);
            }
        });

        ContentResolver cr = getContentResolver();
        Cursor c = cr.query(Contacts.CONTENT_URI, new String[]{Contacts._ID, Contacts.DISPLAY_NAME}, null, null, null);
        if (c != null) {
            while (c.moveToNext()) {
                int id = c.getInt(c.getColumnIndex(Contacts._ID));
                String name = c.getString(c.getColumnIndex(Contacts.DISPLAY_NAME));
                Log.i("info", "_id: " + id);
                Log.i("info", "name: " + name);
                Cursor c1 = cr.query(Phone.CONTENT_URI, new String[]{Phone.NUMBER, Phone.TYPE}, Phone.CONTACT_ID + "=" + id, null, null, null);
                //根据联系人ID查询出联系人的电话号码
                if (c1 != null) {
                    while (c1.moveToNext()) {
                        int type = c1.getInt(c1.getColumnIndex(Phone.TYPE));
                        String number = c1.getString(c1.getColumnIndex(Phone.NUMBER));
                        if (type == Phone.TYPE_HOME) {
                            Log.i("info", "家庭电话: " + number);
                        } else if (type == Phone.TYPE_MOBILE) {
                            Log.i("info", "手机: " + number);
                        }
                    }
                    c1.close();
                }
                //根据联系人的ID去查询出联系人的邮箱地址
                Cursor c2 = cr.query(Email.CONTENT_URI, new String[]{Email.DATA, Email.TYPE}, Email.CONTACT_ID + "=" + id, null, null);
                if (c2 != null) {
                    while (c2.moveToNext()) {
                        int data = c2.getInt(c2.getColumnIndex(Email.DATA));
                        int type = c2.getInt(c2.getColumnIndex(Email.TYPE));
                        if (type == Email.TYPE_WORK) {
                            Log.i("info", "工作邮箱: "+data);
                        }
                    }
                    c2.close();
                }
            }
            c.close();
        }
    }
}
