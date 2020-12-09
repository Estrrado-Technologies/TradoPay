package com.estrrado.tradopay.ui.modules.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.estrrado.tradopay.listener.OnItemSelectedlistner
import com.estrrado.tradopay.ui.modules.home.adapter.SearchSampleItemAdapter.SearchSampleViewHolder
import com.example.tradopay.R

class SearchSampleItemAdapter(var onItemSelectedlistner: OnItemSelectedlistner, var arr: Array<String>) : RecyclerView.Adapter<SearchSampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchSampleViewHolder {
        return SearchSampleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.search_sample_item, parent, false))
    }

    override fun onBindViewHolder(holder: SearchSampleViewHolder, position: Int) {
        holder.txtSearchTrend.text = arr[position]
        holder.itemView.setOnClickListener { onItemSelectedlistner.onItemClick(null, position) }
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    inner class SearchSampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtSearchTrend: TextView

        init {
            txtSearchTrend = itemView.findViewById(R.id.txtSearchTrend)
        }
    }
}