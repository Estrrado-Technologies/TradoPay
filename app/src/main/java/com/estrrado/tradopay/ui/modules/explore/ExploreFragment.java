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


import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.estrrado.tradopay.ui.modules.home.HomeViewModel;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemsDetailAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.SearchSampleItemAdapter;
import com.estrrado.tradopay.ui.utilities.ItemOffsetDecoration;
import com.example.tradopay.R;

import static android.content.Context.INPUT_METHOD_SERVICE;

public class ExploreFragment extends Fragment {

    private HomeViewModel homeViewModel;
    RecyclerView rcvSearch, rcvCusins, rcvOffers;
    EditText icSearch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_explore, container, false);
        icSearch = root.findViewById(R.id.icSearch);
        rcvSearch = root.findViewById(R.id.rcvSearchItem);
        rcvCusins = root.findViewById(R.id.rcvSearchCusins);
        rcvOffers = root.findViewById(R.id.rcvSearchOffer);
        rcvSearch.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        rcvCusins.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rcvOffers.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.HORIZONTAL, false));
        rcvSearch.addItemDecoration(new ItemOffsetDecoration(4));
        rcvCusins.addItemDecoration(new ItemOffsetDecoration(4));
        rcvOffers.addItemDecoration(new ItemOffsetDecoration(4));
        rcvCusins.setAdapter(new HomeItemsDetailAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        }));
        rcvOffers.setAdapter(new HomeItemsDetailAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        }));
        rcvSearch.setAdapter(new SearchSampleItemAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {

            }
        }));
     /*   final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;
    }

    public void onClick(View v) {
        InputMethodManager im = ((InputMethodManager) getContext().getSystemService(INPUT_METHOD_SERVICE));
        im.showSoftInput(v, 0);
    }
}