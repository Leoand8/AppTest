package com.baichuan.apptest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.baichuan.adapter.ImageAdapter;

/**
 * Created by Administrator on 2016/3/22.
 */
public class GalleryActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, ViewSwitcher.ViewFactory {

    private int[] res = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};
    private Gallery gallery;
    private ImageAdapter adapter;
    private ImageSwitcher imageSwitcher;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gallery = (Gallery) findViewById(R.id.gallery);
        imageSwitcher = (ImageSwitcher) findViewById(R.id.gallery_imageSwitcher);

        //gallery加载适配器
        adapter = new ImageAdapter(res, this);
        gallery.setAdapter(adapter);
        gallery.setOnItemSelectedListener(this);
        imageSwitcher.setFactory(this);
        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,android.R.anim.fade_out));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        image.setBackgroundResource(res[position%res.length]);
        imageSwitcher.setBackgroundResource(res[position % res.length]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public View makeView() {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);

        return imageView;
    }
}
