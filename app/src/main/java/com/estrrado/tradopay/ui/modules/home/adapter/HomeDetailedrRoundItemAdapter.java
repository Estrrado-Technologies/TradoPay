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

public class HomeDetailedrRoundItemAdapter extends RecyclerView.Adapter<HomeDetailedrRoundItemAdapter.HomeDetailedrRoundItemViewHolder> {

    OnItemSelectedlistner onItemSelectedlistner;
    String[] arr;int[] imgs;
    public HomeDetailedrRoundItemAdapter(OnItemSelectedlistner onItemSelectedlistner, String[] headings_detail, int[] images_detail) {
        this.onItemSelectedlistner=onItemSelectedlistner;
        this.arr=headings_detail;
        this.imgs=images_detail;
    }

    @NonNull
    @Override
    public HomeDetailedrRoundItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeDetailedrRoundItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_detail_item_round,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeDetailedrRoundItemViewHolder holder, int position) {
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
        return arr.length;
    }

    public class HomeDetailedrRoundItemViewHolder extends RecyclerView.ViewHolder
    {
        TextView txt;
        ImageView img;
        public HomeDetailedrRoundItemViewHolder(@NonNull View itemView) {
            super(itemView);
            txt=itemView.findViewById(R.id.txtItemName);
            img=itemView.findViewById(R.id.imgDetailRound);
        }
    }
}
