package com.alonz.reumanatlot_mvvm.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.alonz.reumanatlot_mvvm.R;
import com.alonz.reumanatlot_mvvm.Utils.FragmentUtils;

public class HomeFragment extends Fragment implements View.OnClickListener {

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Toolbar actionBar =  getActivity().findViewById(R.id.toolbar);
        actionBar.setVisibility(View.GONE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(actionBar);
        View view= inflater.inflate(R.layout.fragment_home, container, false);

// 0=Natla, 1=KidushCup, 2 = Meyham, 3= Holders, 4= Sakomonim, 5=Salt
        Button natlotButton = view.findViewById(R.id.natlotButton);
        Button kidushButton = view.findViewById(R.id.kidushButton);
        Button meyhamButton = view.findViewById(R.id.meyhamButton);
        Button holdersButton = view.findViewById(R.id.holdersButton);
        Button sakomonimButton = view.findViewById(R.id.sacomonimButton);
        Button saltButton = view.findViewById(R.id.saltButton);

        natlotButton.setOnClickListener(this);
        kidushButton.setOnClickListener(this);
        meyhamButton.setOnClickListener(this);
        holdersButton.setOnClickListener(this);
        sakomonimButton.setOnClickListener(this);
        saltButton.setOnClickListener(this);

    return view;
    }

    @Override
    public void onClick(View view) {
        ItemsMainFragment itemsMainFragment;
        NatlotMainFragment natlotMainFragment;
        switch (view.getId()){
            case R.id.natlotButton:
                natlotMainFragment = NatlotMainFragment.newInstance();
                FragmentUtils.swapFragment(natlotMainFragment,getFragmentManager());
            break;
            case R.id.kidushButton:
                itemsMainFragment = ItemsMainFragment.newInstance(1);
                FragmentUtils.swapFragment(itemsMainFragment,getFragmentManager());
                break;
            case R.id.meyhamButton:
                itemsMainFragment = ItemsMainFragment.newInstance(2);
                FragmentUtils.swapFragment(itemsMainFragment,getFragmentManager());
                break;
            case R.id.holdersButton:
                itemsMainFragment = ItemsMainFragment.newInstance(3);
                FragmentUtils.swapFragment(itemsMainFragment,getFragmentManager());
                break;
            case R.id.sacomonimButton:
                itemsMainFragment = ItemsMainFragment.newInstance(4);
                FragmentUtils.swapFragment(itemsMainFragment,getFragmentManager());
                break;

            case R.id.saltButton:
                itemsMainFragment = ItemsMainFragment.newInstance(5);
                itemsMainFragment.setRetainInstance(true);
                FragmentUtils.swapFragment(itemsMainFragment,getFragmentManager());
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Toolbar actionBar =  getActivity().findViewById(R.id.toolbar);
        actionBar.setVisibility(View.VISIBLE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(actionBar);
    }
}
