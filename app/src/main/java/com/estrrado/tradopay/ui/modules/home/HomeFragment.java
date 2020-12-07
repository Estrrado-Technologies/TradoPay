package com.estrrado.tradopay.ui.modules.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.estrrado.tradopay.ui.modules.MainActivity;
import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.estrrado.tradopay.ui.modules.home.adapter.BannerViewPagerAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemsListAdapter;
import com.example.tradopay.R;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import me.huseyinozer.TooltipIndicator;


public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ViewPager vpBannerSlider;
    TooltipIndicator indicator;
    String headings[] [] ={{"Delivery At Your Doorsteps","Restaurants,Bakery,Grocery,Household Items and many other items","Order Now"},{"Book Your Appointments","Doctors,Car/Bike Wash & Service centers,, Saloons,Spa/Parlors,Gyms and other services","Book Now"},{"Cashbacks and Offers" ,"View Cashbacks and Offers","View All"}};
    int[] images={R.drawable.scty_grl,R.drawable.appoinmt,R.drawable.sale};
    private TextView txtAdHead;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        vpBannerSlider =root.findViewById(R.id.vpBannerSlider);
        indicator =root.findViewById(R.id.tooltip_indicator);
        txtAdHead =root.findViewById(R.id.txtAdHead);
        RecyclerView rcvHomeItems = root.findViewById(R.id.rcvHomeItems);
        rcvHomeItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        txtAdHead.setText("Today's Top Deals");
        rcvHomeItems.setAdapter(new HomeItemsListAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {
              //  NavController controller = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);

                //controller.navigate(R.id.action_home);
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeListItemDetailFragment()).commit();
            }
        },headings,images));

//        FragmentContainerView fragmentContainerView =root.findViewById(R.id.fcvHomeScreen);
       BannerViewPagerAdapter adapter = new BannerViewPagerAdapter(getActivity());
        vpBannerSlider.setAdapter(adapter);
        indicator.setupViewPager(vpBannerSlider);

        indicator.setToolTipDrawables(Arrays.asList(
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_top),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_bottom),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_background),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_top),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_bottom)
        ));

       /* supportFragmentManager.beginTransaction()
                .setCustomAnimations(R.anim.slide_in_from_right, R.anim.slide_out_to_left,
                        R.anim.slide_in_from_left, R.anim.slide_out_to_right)
                .replace(R.id.fragmentContainerView, myFragment)
                .commit().*/
       /* getActivity().getSupportFragmentManager().beginTransaction()
                .add(R.id.fcvHomeScreen, new HomeIItemListFragment())
                .commit();*/
     //   final TextView textView = root.findViewById(R.id.text_home);
      /*  homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("getActivity=",""+getActivity());
        MainActivity activity= (MainActivity) getActivity();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(activity), 2000, 4000);
    }

    public class MyTimerTask extends TimerTask {

        MainActivity activity;
        public MyTimerTask(MainActivity act) {
            activity=act;
        }
        @Override
        public void run() {

           activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(vpBannerSlider.getCurrentItem() == 0){
                        vpBannerSlider.setCurrentItem(1);
                    } else if(vpBannerSlider.getCurrentItem() == 1){
                        vpBannerSlider.setCurrentItem(2);
                    } else {
                        vpBannerSlider.setCurrentItem(0);
                    }

                }
            });

        }
    }
}