package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.estrrado.tradopay.viewmodel.WalletViewModel
import com.example.tradopay.R

class WalletFragment : Fragment() {
    private var dashboardViewModel: WalletViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        dashboardViewModel = ViewModelProvider(this).get(WalletViewModel::class.java)
        /*  final TextView textView = root.findViewById(R.id.text_dashboard);
      dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          @Override
          public void onChanged(@Nullable String s) {
              textView.setText(s);
          }
      });*/return inflater.inflate(R.layout.fragment_wallet, container, false)
    }
}