package com.example.asus.liexi3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

/**
 * Created by asus on 2019/8/21.
 */

public class Rv_Adager extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private ArrayList<Fuli_Adager.ResultsBean> list;
    private Context context;

    public Rv_Adager(ArrayList<Fuli_Adager.ResultsBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item, null);
        item item = new item(inflate);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        item holder1 = (item) holder;
        Glide.with(context).load(list.get(position).getUrl()).into(holder1.img);
        holder1.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liu.liu(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class item extends RecyclerView.ViewHolder {

        private final ImageView img;

        public item(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }
    interface Liu{
        void liu(int position);
    }
    Liu liu;

    public void setLiu(Liu liu) {
        this.liu = liu;
    }
}
