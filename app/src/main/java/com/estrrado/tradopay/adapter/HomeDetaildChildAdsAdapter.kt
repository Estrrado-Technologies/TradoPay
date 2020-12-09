package com.estrrado.tradopay.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estrrado.tradopay.listener.OnItemSelectedlistner

import com.example.tradopay.R

class HomeDetaildChildAdsAdapter(onItemSelectedlistner: OnItemSelectedlistner, headings_ads: Array<String>, imagAds: IntArray) : RecyclerView.Adapter<HomeDetaildChildAdsAdapter.HomeItemsListViewHolder>() {
    var onItemSelectedlistner: OnItemSelectedlistner
    var arr: Array<String>
    var imgs: IntArray
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeItemsListViewHolder {
        return HomeItemsListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_ads_detaild_child, parent, false))
    }

    override fun onBindViewHolder(holder: HomeItemsListViewHolder, position: Int) {
        holder.img.setImageResource(imgs[position])
        holder.txt.text = arr[position]
        holder.itemView.setOnClickListener { onItemSelectedlistner.onItemClick(null, position) }
    }

    override fun getItemCount(): Int {
        return 2
    }

    inner class HomeItemsListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txt: TextView
        var img: ImageView

        init {
            txt = itemView.findViewById(R.id.txtAd)
            img = itemView.findViewById(R.id.imgAd)
        }
    }

    init {
        this.onItemSelectedlistner = onItemSelectedlistner
        arr = headings_ads
        imgs = imagAds
    }
}