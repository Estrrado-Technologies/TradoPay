package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.estrrado.tradopay.viewmodel.HomeViewModel
import com.example.tradopay.R

class FavouriteFragment : BaseFragment() {
    private var homeViewModel: HomeViewModel? = null

    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun initListeners(view: View) {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
}