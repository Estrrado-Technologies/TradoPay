package com.estrrado.tradopay.ui.modules.home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.tradopay.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeDetailedActivity extends AppCompatActivity {
    Toolbar toolbar;
    private NavController.OnDestinationChangedListener onDestinationChangedListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        BottomNavigationView navView = findViewById(R.id.nav_view);
         toolbar = findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_detailed, R.id.navigation_explore, R.id.navigation_notifications,R.id.navigation_wallet,R.id.navigation_favourites)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        onDestinationChangedListener=new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Fragment fragment=getSupportFragmentManager().getPrimaryNavigationFragment().getChildFragmentManager().getPrimaryNavigationFragment();
                if(fragment instanceof HomeItemDetailChildFragment)
                {
                    navView.setSelectedItemId(R.id.navigation_detailed);
                }

            }

    };

    }
}