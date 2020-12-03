package com.estrrado.tradopay.ui.modules.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.estrrado.tradopay.ui.modules.OnItemSelectedlistner;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeDetailedrRoundItemAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemsDetailAdapter;
import com.estrrado.tradopay.ui.modules.home.adapter.HomeItemsListAdapter;
import com.example.tradopay.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeListItemDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeListItemDetailFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeListItemDetailFragment() {
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
    public static HomeListItemDetailFragment newInstance(String param1, String param2) {
        HomeListItemDetailFragment fragment = new HomeListItemDetailFragment();
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
        View view=inflater.inflate(R.layout.fragment_home_detail, container, false);
        RecyclerView rcvItems= view.findViewById(R.id.rcvItems);
        RecyclerView rcvHomeItems= view.findViewById(R.id.rcvHomeItemsDetail);
        rcvItems.setLayoutManager(new GridLayoutManager(getActivity(),4));
        rcvHomeItems.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvItems.setAdapter(new HomeDetailedrRoundItemAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {
               // Toast.makeText(getContext(),"Clicked",Toast.LENGTH_LONG).show();
               //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeItemDetailChildFragment()).commit();
                startActivity(new Intent(getActivity(),HomeDetailedActivity.class));
            }
        }));
        rcvHomeItems.setAdapter(new HomeItemsListAdapter(new OnItemSelectedlistner() {
            @Override
            public void onItemClick(Object object, int position) {
               // Toast.makeText(getContext(),"Clicked",Toast.LENGTH_LONG).show();
               // getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeItemDetailChildFragment()).commit();
            }
        }));
        return view;
    }
}