package com.estrrado.tradopay.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.estrrado.tradopay.fragments.HomeFragment
import com.example.tradopay.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.util.*

class MainActivity : AppCompatActivity() {
    var toolbar: Toolbar? = null
    var navController: NavController? = null
    var navHostFragment: NavHostFragment? = null
    var onDestinationChangedListener: OnDestinationChangedListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var navView: BottomNavigationView? = findViewById(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)
        //  toolbarExplore = findViewById(R.id.toolbarExplore);
        setSupportActionBar(toolbar)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_explore, R.id.navigation_notifications, R.id.navigation_wallet, R.id.navigation_favourites)
                .build()
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController!!, appBarConfiguration)
        if (navView != null) {
            NavigationUI.setupWithNavController(navView, navController!!)
        }
        onDestinationChangedListener = OnDestinationChangedListener { controller, destination, arguments ->
            val fragment = Objects.requireNonNull(supportFragmentManager.primaryNavigationFragment)?.childFragmentManager?.primaryNavigationFragment
            if (fragment is HomeFragment) {
                if (navView != null) {
                    navView.setSelectedItemId(R.id.navigation_home)
                }
            }
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
    }

    override fun onResume() {
        super.onResume()
        navController!!.addOnDestinationChangedListener(onDestinationChangedListener!!)
    }

    override fun onPause() {
        super.onPause()
        navController!!.removeOnDestinationChangedListener(onDestinationChangedListener!!)
    }

    /*  private void manageToolBars(int toolbarId) {
        if(toolbarId==R.id.toolbarExplore)
        {
            toolbar.setVisibility(View.GONE);
            toolbarExplore.setVisibility(View.VISIBLE);
            setSupportActionBar(toolbarExplore);
        }
        else
        {
            toolbar.setVisibility(View.VISIBLE);
            toolbarExplore.setVisibility(View.GONE);
            setSupportActionBar(toolbar);
        }

    }*/
    override fun onBackPressed() {
        super.onBackPressed()
    }

    interface OnExploreActivityOpenListener {
        fun onOpen()
    }
}