package com.alonz.reumanatlot_mvvm.Fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.alonz.reumanatlot_mvvm.Adapters.NatlaAdapter;
import com.alonz.reumanatlot_mvvm.R;

/**
 * Created by alonz on 15/11/2017.
 */

public class NatlotFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private RecyclerView recycleView;
    private ProgressBar pb;
    private int mPosition;
    public NatlotFragment() {
        // Required empty public constructor
    }


    public static NatlotFragment newInstance(int param1) {
        NatlotFragment fragment = new NatlotFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPosition = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.natlot_recycler_view, container, false);
        pb = rootView.findViewById(R.id.pb_natlot_list);
        pb.setVisibility(View.VISIBLE);

        recycleView =  rootView.findViewById(R.id.recyclerview);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new GridLayoutManager(getContext(), 2));

        recycleView.setAdapter(new NatlaAdapter(getContext(), mPosition));
        pb.setVisibility(View.INVISIBLE);

        return rootView;
    }


}

