package com.estrrado.tradopay.helpers

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.tradopay.R

object ActivityUtils {
    fun onBackPress(activity: AppCompatActivity?, mAppBarConfiguration: AppBarConfiguration?, nav_host_fragment: Int): Boolean {
        val navController = Navigation.findNavController(activity!!, R.id.nav_host_fragment)
        return NavigationUI.navigateUp(navController, mAppBarConfiguration!!)
    }

    fun set_back_button(context: Context, enable: Boolean) {
        (context as AppCompatActivity).supportActionBar!!.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24)
        context.supportActionBar!!.setDisplayHomeAsUpEnabled(enable)
    }
}