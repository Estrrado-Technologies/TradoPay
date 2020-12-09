package com.estrrado.tradopay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import com.example.tradopay.R

class HomeItemsListAdapter(var onItemSelectedlistner: OnItemSelectedlistner, var headings: Array<Array<String>>, var images: IntArray) : RecyclerView.Adapter<HomeItemsListAdapter.HomeItemsListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsListViewHolder {
        return HomeItemsListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_home_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeItemsListViewHolder, position: Int) {
        holder.imgBg.setImageResource(images[position])
        holder.txtHomeItem.text = headings[position][0]
        holder.txtHomeItemDetail.text = headings[position][1]
        holder.btnProceed.text = headings[position][2]
        holder.itemView.setOnClickListener { onItemSelectedlistner.onItemClick(null, position) }
    }

    override fun getItemCount(): Int {
        return images.size
    }

    inner class HomeItemsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtHomeItem: TextView
        var txtHomeItemDetail: TextView
        var imgBg: ImageView
        var btnProceed: AppCompatButton

        init {
            txtHomeItem = itemView.findViewById(R.id.txtHomeItem)
            txtHomeItemDetail = itemView.findViewById(R.id.txtHomeItemDetail)
            imgBg = itemView.findViewById(R.id.imgHomeItemBg)
            btnProceed = itemView.findViewById(R.id.btnProceed)
        }
    }
}