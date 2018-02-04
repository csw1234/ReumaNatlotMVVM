package com.alonz.reumanatlot_mvvm.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.alonz.reumanatlot_mvvm.R;
import com.squareup.picasso.Picasso;

public class FullScreenFragment extends Fragment {
    ProgressBar pb;
    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    public FullScreenFragment() {
        // Required empty public constructor
    }

    public static FullScreenFragment newInstance(String param1) {
        FullScreenFragment fragment = new FullScreenFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_full_screen, container, false);
        pb = view.findViewById(R.id.pb_fullscreen);
        pb.setVisibility(View.VISIBLE);
        ImageView imageView = view.findViewById(R.id.full_screen);
        ImageView closeView = view.findViewById(R.id.close_full_screen);
        closeView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove();
            }
        });
        Picasso.with(getContext()).load(mParam1).into(imageView);

        return view;

    }

    public void remove() {
        getFragmentManager().beginTransaction().remove(this).commit();
    }
}



