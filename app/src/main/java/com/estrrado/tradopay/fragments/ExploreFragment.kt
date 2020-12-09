package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.estrrado.tradopay.adapter.HomeItemsDetailAdapter
import com.estrrado.tradopay.helpers.ItemOffsetDecoration
import com.estrrado.tradopay.listener.OnItemSelectedlistner

import com.estrrado.tradopay.ui.modules.home.adapter.SearchSampleItemAdapter
import com.estrrado.tradopay.viewmodel.ExploreViewModel

import com.example.tradopay.R

class ExploreFragment : Fragment() {
    private var exploreViewModel: ExploreViewModel? = null
    var icSearch: EditText? = null
    var images = intArrayOf(R.drawable.puttu, R.drawable.prawns_biriyani, R.drawable.burger, R.drawable.alcohol, R.drawable.puttu)
    var images_offer = intArrayOf(R.drawable.restrnt, R.drawable.restrnt, R.drawable.restrnt, R.drawable.restrnt, R.drawable.restrnt)
    var headings_trend = arrayOf("Biriyani", "Pizza", "Kuttanad Hotel", "Meals", "Mithai", "Pankaj Hotel", "Taj Hotel")
    var headings_cusin = arrayOf(" South Indian", "Biriyani", "Burger", "Bevereges", " South Indian")
    var headings_offer = arrayOf("Zam Zam", "Pankaj Hotel", "Puttukada", "Rajadhani", "Taj")
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        exploreViewModel = ViewModelProvider(this).get<ExploreViewModel>(ExploreViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_explore, container, false)
        icSearch = root.findViewById(R.id.icSearch)
        var rcvSearch: RecyclerView? = root.findViewById(R.id.rcvSearchItem)
        var rcvCusins: RecyclerView? = root.findViewById(R.id.rcvSearchCusins)
        var rcvOffers: RecyclerView? = root.findViewById(R.id.rcvSearchOffer)
        //rcvSearch.setLayoutManager(new GridLayoutManager(getActivity(), 4));
// set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        val staggeredGridLayoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.HORIZONTAL)
        val gridLayoutManager = GridLayoutManager(context, 3, GridLayoutManager.VERTICAL, false)
        if (rcvCusins != null) {
            rcvCusins.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false));
            rcvCusins.addItemDecoration(ItemOffsetDecoration(5));
            rcvCusins.setAdapter(HomeItemsDetailAdapter(object : OnItemSelectedlistner {
                override fun onItemClick(`object`: Any?, position: Int) {}
            }, headings_cusin, images))
        }
        if (rcvOffers != null) {
            rcvOffers.setLayoutManager(LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false));
            rcvOffers.addItemDecoration(ItemOffsetDecoration(5))
            rcvOffers.setAdapter(HomeItemsDetailAdapter(object : OnItemSelectedlistner {
                override fun onItemClick(`object`: Any?, position: Int) {}
            }, headings_offer, images_offer))
        }
        if (rcvSearch != null) {
            rcvSearch.setLayoutManager(gridLayoutManager)
            rcvSearch.addItemDecoration(ItemOffsetDecoration(5));
            rcvSearch.setHasFixedSize(true)
            rcvSearch.setAdapter(SearchSampleItemAdapter(object : OnItemSelectedlistner {
                override fun onItemClick(`object`: Any?, position: Int) {}
            }, headings_trend))
        }

        return root;
    }
}