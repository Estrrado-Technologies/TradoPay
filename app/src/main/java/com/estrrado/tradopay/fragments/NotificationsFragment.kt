package com.estrrado.tradopay.ui.modules.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.estrrado.tradopay.viewmodel.NotificationsViewModel
import com.example.tradopay.R

class NotificationsFragment : Fragment() {
    private var notificationsViewModel: NotificationsViewModel? = null
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        notificationsViewModel = ViewModelProvider(this).get(NotificationsViewModel::class.java)
        /*  final TextView textView = root.findViewById(R.id.text_notifications);
      notificationsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
          @Override
          public void onChanged(@Nullable String s) {
              textView.setText(s);
          }
      });*/return inflater.inflate(R.layout.fragment_notifications, container, false)
    }
}