package com.estrrado.tradopay.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.estrrado.tradopay.viewmodel.HomeViewModel
import com.example.tradopay.R

class FavouriteFragment : Fragment() {
    private var homeViewModel: HomeViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        /*   final TextView textView = root.findViewById(R.id.text_home);
      homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          @Override
          public void onChanged(@Nullable String s) {
              textView.setText(s);
          }
      });*/return inflater.inflate(R.layout.fragment_favourite, container, false)
    }
}