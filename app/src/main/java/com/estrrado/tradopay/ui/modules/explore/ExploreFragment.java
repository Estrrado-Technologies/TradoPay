package com.estrrado.tradopay.ui.modules.explore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;


import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.estrrado.tradopay.ui.modules.home.HomeViewModel;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemsDetailAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.SearchSampleItemAdapter;
import com.estrrado.tradopay.ui.utilities.ActivityUtils;
import com.estrrado.tradopay.ui.utilities.ItemOffsetDecoration;
import com.example.tradopay.R;

import java.util.Objects;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class ExploreFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView rcvSearch, rcvCusins, rcvOffers;
    EditText icSearch;
    int[] images={R.drawable.puttu,R.drawable.prawns_biriyani,R.drawable.burger,R.drawable.alcohol,R.drawable.puttu};
    int[] images_offer={R.drawable.restrnt,R.drawable.restrnt,R.drawable.restrnt,R.drawable.restrnt,R.drawable.restrnt};
    String[] headings_trend={"Biriyani","Pizza","Kuttanad Hotel","Meals","Mithai","Pankaj Hotel","Taj Hotel"};
    String[] headings_cusin={" South Indian","Biriyani","Burger","Bevereges"," South Indian"};
    String[] headings_offer={"Zam Zam","Pankaj Hotel","Puttukada","Rajadhani","Taj"};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_explore, container, false);
        icSearch = root.findViewById(R.id.icSearch);
        rcvSearch = root.findViewById(R.id.rcvSearchItem);
        rcvCusins = root.findViewById(R.id.rcvSearchCusins);
        rcvOffers = root.findViewById(R.id.rcvSearchOffer);
        //rcvSearch.setLayoutManager(new GridLayoutManager(getActivity(), 4));
// set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(4, LinearLayoutManager.VERTICAL);
        rcvSearch.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        rcvCusins.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rcvOffers.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rcvSearch.addItemDecoration(new ItemOffsetDecoration(5));
        rcvCusins.addItemDecoration(new ItemOffsetDecoration(5));
        rcvOffers.addItemDecoration(new ItemOffsetDecoration(5));
        rcvCusins.setAdapter(new HomeItemsDetailAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        },headings_cusin,images));
        rcvOffers.setAdapter(new HomeItemsDetailAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        },headings_offer, images_offer));
        rcvSearch.setAdapter(new SearchSampleItemAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        },headings_trend));
     /*   final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

   /* public void onClick(View v) {
        InputMethodManager im = (InputMethodManager) Objects.requireNonNull(getContext()).getSystemService(INPUT_METHOD_SERVICE);
        im.showSoftInput(v, 0);
    }*/
}