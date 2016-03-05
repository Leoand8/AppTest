package com.baichuan.apptest;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by Administrator on 2016/3/5.
 */
public class PickerActivity extends Activity {

    private DatePicker datePicker;
    private TimePicker timePicker;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private int hour;
    private int minute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        //获取日历的一个对象
        calendar = Calendar.getInstance();
        //获取年月日时分秒的信息
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH) + 1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hour = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        Toast.makeText(this, year + "-" + month + "-" + day + "-" + hour + "-" + minute, Toast.LENGTH_SHORT).show();
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //datePicker初始化
        datePicker.init(year, calendar.get(Calendar.MONTH), day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                System.out.println(year + "y" + (monthOfYear + 1) + "m" + dayOfMonth + "d");

            }
        });

        //timePicker初始化
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                System.out.println(hourOfDay + "h" + minute + "m");
            }
        });

        new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                System.out.println(year + "y" + (monthOfYear + 1) + "m" + dayOfMonth + "d");
            }
        }, year, calendar.get(Calendar.MONTH), day).show();

        new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                System.out.println(hourOfDay + "h" + minute + "m");
            }
        },hour,minute,true).show();
    }
}
