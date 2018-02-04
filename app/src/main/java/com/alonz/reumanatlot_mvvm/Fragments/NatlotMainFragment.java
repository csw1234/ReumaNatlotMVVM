package com.alonz.reumanatlot_mvvm.Fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alonz.reumanatlot_mvvm.R;

public class NatlotMainFragment extends Fragment {
    public NatlotMainFragment() {
        // Required empty public constructor
    }
    public static NatlotMainFragment newInstance() {
        NatlotMainFragment fragment = new NatlotMainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_natlot, container, false);
        // Find the view pager that will allow the user to swipe between fragments
        ViewPager viewPager =  view.findViewById(R.id.viewpager);

        // Create an adapter that knows which fragment should be shown on each page
        SimpleFragmentPagerAdapter adapter = new SimpleFragmentPagerAdapter(getFragmentManager());
        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        TabLayout tabLayout =  view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    return view;
    }

}
