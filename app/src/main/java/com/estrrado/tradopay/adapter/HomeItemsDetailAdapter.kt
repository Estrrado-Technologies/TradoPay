package com.estrrado.tradopay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import com.example.tradopay.R

class HomeItemsDetailAdapter(var onItemSelectedlistner: OnItemSelectedlistner, var arr: Array<String>, var imgs: IntArray) : RecyclerView.Adapter<HomeItemsDetailAdapter.HomeItemsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsListViewHolder {
        return HomeItemsListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_detail_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeItemsListViewHolder, position: Int) {
        holder.img.setImageResource(imgs[position])
        holder.txt.text = arr[position]
        holder.itemView.setOnClickListener { onItemSelectedlistner.onItemClick(null, position) }
    }

    override fun getItemCount(): Int {
        return imgs.size
    }

    inner class HomeItemsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt: TextView
        var img: ImageView

        init {
            txt = itemView.findViewById(R.id.txtItemName)
            img = itemView.findViewById(R.id.imgItem)
        }
    }
}