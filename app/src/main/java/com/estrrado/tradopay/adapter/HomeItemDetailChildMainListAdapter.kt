package com.estrrado.tradopay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import com.example.tradopay.R

class HomeItemDetailChildMainListAdapter(var onItemSelectedlistner: OnItemSelectedlistner) : RecyclerView.Adapter<HomeItemDetailChildMainListAdapter.HomeItemsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsListViewHolder {
        return HomeItemsListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_item_child_main_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeItemsListViewHolder, position: Int) {
        holder.itemView.setOnClickListener { onItemSelectedlistner.onItemClick(null, position) }
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class HomeItemsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}