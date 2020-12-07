package com.estrrado.tradopay.ui.modules;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.estrrado.tradopay.ui.modules.explore.ExploreFragment;
import com.estrrado.tradopay.ui.modules.home.HomeFragment;
import com.example.tradopay.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import java.util.Objects;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    NavController navController;
    BottomNavigationView navView;
    NavHostFragment navHostFragment;
    NavController.OnDestinationChangedListener onDestinationChangedListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         navView = findViewById(R.id.nav_view);
         toolbar = findViewById(R.id.toolbar);
       //  toolbarExplore = findViewById(R.id.toolbarExplore);
         setSupportActionBar(toolbar);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_explore, R.id.navigation_notifications,R.id.navigation_wallet,R.id.navigation_favourites)
                .build();
         navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        onDestinationChangedListener=new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                Fragment fragment= Objects.requireNonNull(getSupportFragmentManager().getPrimaryNavigationFragment()).getChildFragmentManager().getPrimaryNavigationFragment();
               if(fragment instanceof HomeFragment)
               {
                   navView.setSelectedItemId(R.id.navigation_home);
               }

            }
        };

    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

    }

    @Override
    protected void onResume() {
        super.onResume();
        navController.addOnDestinationChangedListener(onDestinationChangedListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navController.removeOnDestinationChangedListener(onDestinationChangedListener);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(MainActivity.this,"primary="+ Objects.requireNonNull(getSupportFragmentManager().getPrimaryNavigationFragment()).getClass().getSimpleName(),Toast.LENGTH_LONG).show();
    }
    public interface OnExploreActivityOpenListener
    {
       void onOpen();
    }
}