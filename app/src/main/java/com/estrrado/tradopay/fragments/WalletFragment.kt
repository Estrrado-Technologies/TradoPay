package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.estrrado.tradopay.viewmodel.WalletViewModel
import com.example.tradopay.R

class WalletFragment : BaseFragment() {

    private var dashboardViewModel: WalletViewModel? = null


    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {

        dashboardViewModel = ViewModelProvider(this).get(WalletViewModel::class.java)
        return inflater.inflate(R.layout.fragment_wallet, container, false)

    }

    override fun initListeners(view: View) {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
}