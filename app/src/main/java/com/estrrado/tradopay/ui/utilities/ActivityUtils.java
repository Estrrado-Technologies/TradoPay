package com.estrrado.tradopay.ui.utilities;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tradopay.R;

public class ActivityUtils {
    public static boolean onBackPress(AppCompatActivity activity, AppBarConfiguration mAppBarConfiguration, int nav_host_fragment) {

        NavController navController = Navigation.findNavController(activity, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration);

    }
    public static void set_back_button(Context context,boolean enable) {
        ((AppCompatActivity) context).getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        ((AppCompatActivity) context).getSupportActionBar().setDisplayHomeAsUpEnabled(enable);

    }


}
