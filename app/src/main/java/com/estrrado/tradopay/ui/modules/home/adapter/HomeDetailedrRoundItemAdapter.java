package com.estrrado.tradopay.ui.modules.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.example.tradopay.R;

public class HomeDetailedrRoundItemAdapter extends RecyclerView.Adapter<HomeDetailedrRoundItemAdapter.HomeDetailedrRoundItemViewHolder> {

    OnItemSelectedlistner onItemSelectedlistner;
    public HomeDetailedrRoundItemAdapter(OnItemSelectedlistner onItemSelectedlistner) {
        this.onItemSelectedlistner=onItemSelectedlistner;
    }

    @NonNull
    @Override
    public HomeDetailedrRoundItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeDetailedrRoundItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_detail_item_round,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeDetailedrRoundItemViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelectedlistner.onItemClick(null,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class HomeDetailedrRoundItemViewHolder extends RecyclerView.ViewHolder
    {
        public HomeDetailedrRoundItemViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
