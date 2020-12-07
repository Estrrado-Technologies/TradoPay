package com.estrrado.tradopay.ui.modules.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.example.tradopay.R;

public class HomeItemsListAdapter extends RecyclerView.Adapter<HomeItemsListAdapter.HomeItemsListViewHolder> {
    OnItemSelectedlistner onItemSelectedlistner;
    String[][] headings; int[] images;
    public HomeItemsListAdapter(OnItemSelectedlistner onItemSelectedlistner, String[][] headings, int[] images) {
        this.onItemSelectedlistner=onItemSelectedlistner;
        this.headings=headings;
        this.images=images;
    }

    @NonNull
    @Override
    public HomeItemsListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeItemsListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_home_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeItemsListViewHolder holder, int position) {

        holder.imgBg.setImageResource(images[position]);
        holder.txtHomeItem.setText(headings[position][0]);
        holder.txtHomeItemDetail.setText(headings[position][1]);
        holder.btnProceed.setText(headings[position][2]);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelectedlistner.onItemClick(null,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class HomeItemsListViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtHomeItem;
        TextView txtHomeItemDetail;
        ImageView imgBg;
        AppCompatButton btnProceed;

        public HomeItemsListViewHolder(@NonNull View itemView) {
            super(itemView);
            txtHomeItem=itemView.findViewById(R.id.txtHomeItem);
            txtHomeItemDetail=itemView.findViewById(R.id.txtHomeItemDetail);
            imgBg=itemView.findViewById(R.id.imgHomeItemBg);
            btnProceed=itemView.findViewById(R.id.btnProceed);
        }
    }
}
