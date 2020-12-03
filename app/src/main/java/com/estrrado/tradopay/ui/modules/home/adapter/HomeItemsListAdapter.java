package com.estrrado.tradopay.ui.modules.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.example.tradopay.R;

public class HomeItemsListAdapter extends RecyclerView.Adapter<HomeItemsListAdapter.HomeItemsListViewHolder> {
    OnItemSelectedlistner onItemSelectedlistner;
    public HomeItemsListAdapter(OnItemSelectedlistner onItemSelectedlistner) {
        this.onItemSelectedlistner=onItemSelectedlistner;

    }

    @NonNull
    @Override
    public HomeItemsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeItemsListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemsListViewHolder holder, int position) {

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelectedlistner.onItemClick(null,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class HomeItemsListViewHolder extends RecyclerView.ViewHolder
    {
        public HomeItemsListViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
