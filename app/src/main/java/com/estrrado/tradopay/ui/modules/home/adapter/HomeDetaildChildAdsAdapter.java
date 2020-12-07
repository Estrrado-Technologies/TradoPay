package com.estrrado.tradopay.ui.modules.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.example.tradopay.R;

public class HomeDetaildChildAdsAdapter extends RecyclerView.Adapter<HomeDetaildChildAdsAdapter.HomeItemsListViewHolder> {
    OnItemSelectedlistner onItemSelectedlistner;
    String[] arr;
    int[] imgs;

    public HomeDetaildChildAdsAdapter(OnItemSelectedlistner onItemSelectedlistner, String[] headings_ads, int[] imagAds) {
        this.onItemSelectedlistner=onItemSelectedlistner;
        this.arr=headings_ads;
        this.imgs=imagAds;

    }

    @NonNull
    @Override
    public HomeItemsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeItemsListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_ads_detaild_child,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemsListViewHolder holder, int position) {

        holder.img.setImageResource(imgs[position]);
        holder.txt.setText(arr[position]);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelectedlistner.onItemClick(null,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class HomeItemsListViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt;
        ImageView img;
        public HomeItemsListViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txtAd);
            img=itemView.findViewById(R.id.imgAd);
        }
    }
}
