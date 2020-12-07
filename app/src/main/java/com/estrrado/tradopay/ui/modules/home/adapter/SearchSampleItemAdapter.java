package com.estrrado.tradopay.ui.modules.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.example.tradopay.R;

public class SearchSampleItemAdapter extends RecyclerView.Adapter<SearchSampleItemAdapter.SearchSampleViewHolder> {
    OnItemSelectedlistner onItemSelectedlistner;
    String[] arr;
    public SearchSampleItemAdapter(OnItemSelectedlistner onItemSelectedlistner,String[] arr) {
        this.onItemSelectedlistner=onItemSelectedlistner;
        this.arr= arr;

    }

    @NonNull
    @Override
    public SearchSampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchSampleViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.search_sample_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SearchSampleViewHolder holder, int position) {

        holder.txtSearchTrend.setText(arr[position]);

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

    public class SearchSampleViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtSearchTrend;
        public SearchSampleViewHolder(@NonNull View itemView) {
            super(itemView);
            txtSearchTrend=itemView.findViewById(R.id.txtSearchTrend);
        }
    }
}
