package com.example.asus.liexi3;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.asus.liexi3.Mainper.Mainper;
import com.example.asus.liexi3.Mainview.Mainview;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Mainview, Rv_Adager.Liu, View.OnClickListener {

    private RecyclerView mRv;
    private ArrayList<Fuli_Adager.ResultsBean> resultss = new ArrayList<>();
    private Rv_Adager rv_adager;
    private ViewPager mVip;
    private TextView mName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Mainper mainper = new Mainper(this);
        mainper.Call();
    }

    private void initView() {
        mRv = (RecyclerView) findViewById(R.id.rv);
        mRv.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        //mRv.addItemDecoration(new DividerItemDecoration(this, LinearLayout.VERTICAL));

        rv_adager = new Rv_Adager(resultss, this);
        mRv.setAdapter(rv_adager);
        rv_adager.setLiu(this);
        mRv.setOnClickListener(this);
        mVip = (ViewPager) findViewById(R.id.vip);
        mName = (TextView) findViewById(R.id.name);
    }

    @Override
    public void setdata(ArrayList<Fuli_Adager.ResultsBean> results) {
        resultss.addAll(results);
        rv_adager.notifyDataSetChanged();
    }

    @Override
    public void setter(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void liu(int position) {
        mRv.setVisibility(View.GONE);
        mVip.setVisibility(View.VISIBLE);
        mName.setVisibility(View.VISIBLE);
        ArrayList<ImageView> imageViews = new ArrayList<>();
        for (int i = 0; i < resultss.size(); i++) {
            ImageView imageView = new ImageView(MainActivity.this);
            Glide.with(this).load( resultss.get(i).getUrl()).into(imageView);
            imageViews.add(imageView);
        }
        Vip vip = new Vip(imageViews,mName);
        mVip.setAdapter(vip);
        mVip.setCurrentItem(position);
        //Vip vip = new Vip(resultss);
        //mVip.setAdapter(vip);
        //vip.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rv:
                break;
        }
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            mRv.setVisibility(View.VISIBLE);
            mVip.setVisibility(View.GONE);
            mName.setVisibility(View.GONE);
            return true;
        }else if (keyCode=){
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }*/


    @Override
    public void onBackPressed() {
        if (mRv.getVisibility()!=View.VISIBLE){
            mRv.setVisibility(View.VISIBLE);
            mVip.setVisibility(View.GONE);
            mName.setVisibility(View.GONE);
        }else {
            super.onBackPressed();
        }
    }
}
