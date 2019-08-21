package com.example.asus.liexi3;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by asus on 2019/8/21.
 */

public class Vip extends PagerAdapter {

    private final TextView mName;
    private ArrayList<ImageView> img;

    public Vip(ArrayList<ImageView> img, TextView mName) {
        if (img!=null){
            this.img = img;
        }
        this.mName = mName;
    }

    @Override
    public int getCount() {
        return img.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mName.setText((position)+"/"+"20");
        container.addView(img.get(position));
        return img.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(img.get(position));
    }
}
