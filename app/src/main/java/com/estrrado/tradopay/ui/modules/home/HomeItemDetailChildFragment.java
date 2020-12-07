package com.estrrado.tradopay.ui.modules.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.estrrado.tradopay.ui.modules.MainActivity;
import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.estrrado.tradopay.ui.modules.home.adapter.BannerViewPagerAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeDetailOfferAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeDetaildChildAdsAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemDetailChildMainListAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemsDetailAdapter;
import com.estrrado.tradopay.ui.utilities.ItemOffsetDecoration;
import com.example.tradopay.R;

import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

import me.huseyinozer.TooltipIndicator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeItemDetailChildFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeItemDetailChildFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ViewPager vpBannerSlider;
    RecyclerView griditems,rcvOffers,rcvTrendingList,rcvMainList,rcvAds;
    int[] images={R.drawable.puttu,R.drawable.prawns_biriyani,R.drawable.burger,R.drawable.alcohol,R.drawable.puttu};
    int[] imagAds={R.drawable.chat,R.drawable.scty};
    String[] headings_cusin={" South Indian","Biriyani","Burger","Bevereges"," South Indian"};
    String[] headings_ads={"Booking Appoinments Made Easy","Order Anything From Anywhere"};

    public HomeItemDetailChildFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeItemDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeItemDetailChildFragment newInstance(String param1, String param2) {
        HomeItemDetailChildFragment fragment = new HomeItemDetailChildFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_homedetail_child, container, false);
        BannerViewPagerAdapter adapter = new BannerViewPagerAdapter(getActivity());
        vpBannerSlider = view.findViewById(R.id.vpBannerSlider);
       TextView txtAdHead =view.findViewById(R.id.txtAdHead);
        griditems= view.findViewById(R.id.griditems);
        rcvOffers= view.findViewById(R.id.rcvofferList);
        rcvAds= view.findViewById(R.id.rcvAds);
        rcvTrendingList= view.findViewById(R.id.rcvTrendingList);
        rcvMainList= view.findViewById(R.id.itemList);
        txtAdHead.setText("");
        txtAdHead.setVisibility(View.GONE);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager_rcvOffers=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager_trending=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManager_ads=new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false);
        LinearLayoutManager linearLayoutManagerMain=new LinearLayoutManager(getContext());
       griditems.setLayoutManager(linearLayoutManager);
       griditems.addItemDecoration(new ItemOffsetDecoration(2));
        rcvOffers.setLayoutManager(linearLayoutManager_rcvOffers);
        rcvTrendingList.setLayoutManager(linearLayoutManager_trending);
        rcvMainList.setLayoutManager(linearLayoutManagerMain);
        rcvAds.setLayoutManager(linearLayoutManager_ads);
        rcvTrendingList.addItemDecoration(new ItemOffsetDecoration(10));
        rcvAds.addItemDecoration(new ItemOffsetDecoration(5));
        rcvOffers.addItemDecoration(new ItemOffsetDecoration(10));
        rcvAds.setAdapter(new HomeDetaildChildAdsAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        },headings_ads,imagAds));
        HomeDetailOfferAdapter homeDetailOfferAdapter=new HomeDetailOfferAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        });
        rcvOffers.setAdapter(homeDetailOfferAdapter);
        rcvTrendingList.setAdapter(homeDetailOfferAdapter);
        rcvMainList.setAdapter(new HomeItemDetailChildMainListAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        }));
       griditems.setAdapter(new HomeItemsDetailAdapter(new OnItemSelectedlistner() {
           @Override
           public void onItemClick(Object object, int position) {

           }
       },headings_cusin,images));
        //HomeDetailOfferAdapter
        vpBannerSlider.setAdapter(adapter);
        TooltipIndicator indicator = view.findViewById(R.id.tooltip_indicator);
        indicator.setupViewPager(vpBannerSlider);

        indicator.setToolTipDrawables(Arrays.asList(
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_top),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_bottom),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_launcher_background),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_top),
                ContextCompat.getDrawable(getActivity(), R.drawable.ic_login_bottom)
        ));
        Timer timer = new Timer();
        HomeDetailedActivity activity= (HomeDetailedActivity) getActivity();
        timer.scheduleAtFixedRate(new MyTimerTask(activity), 2000, 4000);
    return view;}


    public class MyTimerTask extends TimerTask {

        HomeDetailedActivity activity;
        public MyTimerTask(HomeDetailedActivity activity1) {
            activity=activity1;
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