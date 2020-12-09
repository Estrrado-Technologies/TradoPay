package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val view = initLayout(inflater, container)
        initListeners(view)
        initObservers()
        return view
    }

    abstract fun initLayout(inflater: LayoutInflater, container: ViewGroup?): View

    abstract fun initListeners(view: View)

    abstract fun initObservers()


}