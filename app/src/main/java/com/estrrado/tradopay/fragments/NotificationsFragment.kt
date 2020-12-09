package com.estrrado.tradopay.ui.modules.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.estrrado.tradopay.fragments.BaseFragment
import com.estrrado.tradopay.viewmodel.NotificationsViewModel
import com.example.tradopay.R

class NotificationsFragment : BaseFragment() {

    private var notificationsViewModel: NotificationsViewModel? = null


    override fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View {

        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun initListeners(view: View) {
        TODO("Not yet implemented")
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
}