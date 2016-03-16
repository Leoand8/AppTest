package com.baichuan.apptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * 简易计算器程序
 * Created by Leoand8 on 2016/3/3.
 */
public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    /**
     * 初始化按钮和EditText以及一个标志flag
     */
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_point;
    Button btn_equal;
    Button btn_plus;
    Button btn_minus;
    Button btn_multiply;
    Button btn_divide;
    Button btn_del;
    Button btn_clear;
    EditText et_input;
    boolean clear_flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        /**
         * 实例化按钮和输入框
         */
        btn_0 = (Button) findViewById(R.id.btn_0);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_point = (Button) findViewById(R.id.btn_point);
        btn_equal = (Button) findViewById(R.id.btn_equal);
        btn_plus = (Button) findViewById(R.id.btn_plus);
        btn_minus = (Button) findViewById(R.id.btn_minus);
        btn_multiply = (Button) findViewById(R.id.btn_multiply);
        btn_divide = (Button) findViewById(R.id.btn_divide);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        et_input = (EditText) findViewById(R.id.et_input);

        /**
         *设置按钮点击事件
         */
        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_plus.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_clear.setOnClickListener(this);
    }

    /**
     * 根据ID获取点击事件
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        String str = et_input.getText().toString();//每点击一次就获取一次显示屏的值
        switch (v.getId()) {
            //当点击数字和小数点时的情况
            case R.id.btn_0:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.btn_point:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + ((Button) v).getText());//获取点击的字符并显示在之前显示屏上的字符后面
                break;
            //点击加减乘除时的情况
            case R.id.btn_plus:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                }
                et_input.setText(str + " " + ((Button) v).getText() + " ");//获取点击的字符并显示在之前显示屏上的字符后面，前后都加一个空格（注意这里还不能点多次）
                break;
            //点击删除按钮时的情况
            case R.id.btn_del:
                if (clear_flag) {
                    clear_flag = false;
                    str = "";
                    et_input.setText("");
                } else if (str != null && !str.equals("")) {
                    et_input.setText(str.substring(0, str.length() - 1));//逐个删除
                }
                break;
            //点击全部清除按钮时的情况
            case R.id.btn_clear:
                clear_flag = false;
                str = "";
                et_input.setText("");//设置为空
                break;
            //点击等号时的情况
            case R.id.btn_equal:
                getResult();
                break;
        }
    }

    /**
     * 计算结果方法
     */
    private void getResult() {
        String exp = et_input.getText().toString();
        if (exp == null || exp.equals("")) {
            return;
        }
        if (!exp.contains(" ")) {
            return;
        }
        if (clear_flag) {
            clear_flag = false;
            return;
        }
        clear_flag = true;
        double result = 0;
        int space = exp.indexOf(" ");
        String s1 = exp.substring(0, space);
        String op = exp.substring(space + 1, space + 2);
        String s2 = exp.substring(space + 3);
        if (!s1.equals("") && !s2.equals("")) {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result = d1 + d2;
            } else if (op.equals("-")) {
                result = d1 - d2;
            } else if (op.equals("×")) {
                result = d1 * d2;
            } else if (op.equals("÷")) {
                if (d2 == 0) {
                    result = 0;
                } else {
                    result = d1 / d2;
                }
            }
            if (!s1.contains(".") && !s2.contains(".") && !op.equals("÷")) {
                int r = (int) result;
                et_input.setText(r + "");
            } else {
                et_input.setText(result + "");
            }
            if (d1 % d2 == 0) {
                int r = (int) result;
                et_input.setText(r + "");
            }
        } else if (!s1.equals("") && s2.equals("")) {
            et_input.setText(exp);
        } else if (s1.equals("") && !s2.equals("")) {
            double d2 = Double.parseDouble(s2);
            if (op.equals("+")) {
                result = 0 + d2;
            } else if (op.equals("-")) {
                result = 0 - d2;
            } else if (op.equals("×")) {
                result = 0;
            } else if (op.equals("÷")) {
                result = 0;
            }
            if (!s2.contains(".")) {
                int r = (int) result;
                et_input.setText(r + "");
            } else {
                et_input.setText(result + "");
            }
        } else {
            et_input.setText("");
        }
    }
}
