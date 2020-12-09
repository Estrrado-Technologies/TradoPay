package com.estrrado.tradopay.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController.OnDestinationChangedListener
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.estrrado.tradopay.fragments.HomeItemDetailChildFragment
import com.example.tradopay.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_detailed.*

class HomeDetailedActivity : BaseActivity() {
    var toolbar: Toolbar? = null
    private var onDestinationChangedListener: OnDestinationChangedListener? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun initLayout() {
        setContentView(R.layout.activity_detailed)
        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration.Builder(R.id.navigation_detailed,
                R.id.navigation_explore, R.id.navigation_notifications, R.id.navigation_wallet,
                R.id.navigation_favourites)
                .build()
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController,appBarConfiguration)
        NavigationUI.setupWithNavController(navView, navController)
    }

    override fun initListeners() {
        onDestinationChangedListener = OnDestinationChangedListener { controller, destination,
                                                                      arguments ->
            val fragment = supportFragmentManager.primaryNavigationFragment!!.
            childFragmentManager.primaryNavigationFragment
            if (fragment is HomeItemDetailChildFragment) {
                nav_view.selectedItemId = R.id.navigation_detailed
            }
        }
    }

    override fun initObservers() {
        TODO("Not yet implemented")
    }
}