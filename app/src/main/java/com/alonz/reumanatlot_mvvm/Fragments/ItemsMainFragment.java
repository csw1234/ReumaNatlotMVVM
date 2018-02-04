package com.alonz.reumanatlot_mvvm.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.alonz.reumanatlot_mvvm.Database.AppDatabase;
import com.alonz.reumanatlot_mvvm.Database.Product;
import com.alonz.reumanatlot_mvvm.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ItemsMainFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private int itemType;

    int mPosition = 0;
    String[] urlStrings;
    ImageView imageView;
    ProgressBar pb;
    Button[] mButtons;

    private OnFragmentInteractionListener mListener;
    public ItemsMainFragment() {
        // Required empty public constructor
    }

    public static ItemsMainFragment newInstance(int itemType) {
        ItemsMainFragment fragment = new ItemsMainFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, itemType);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            itemType = getArguments().getInt(ARG_PARAM1);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,

                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_items_main, container, false);
        Button color1 = view.findViewById(R.id.color1);
        Button color2 = view.findViewById(R.id.color2);
        Button color3 = view.findViewById(R.id.color3);
        Button color4 = view.findViewById(R.id.color4);
        Button color5 = view.findViewById(R.id.color5);
        Button color6 = view.findViewById(R.id.color6);
        Button color7 = view.findViewById(R.id.color7);
        Button color8 = view.findViewById(R.id.color8);
        Button color9 = view.findViewById(R.id.color9);
        Button color10 = view.findViewById(R.id.color10);
        Button color11 = view.findViewById(R.id.color11);
        Button color12 = view.findViewById(R.id.color12);
        imageView= view.findViewById(R.id.meyham);
        pb = view.findViewById(R.id.pb_meyham);
        ImageView favoriteButton = view.findViewById(R.id.favoriteButton);

        final Button[] buttons ={color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12};
        mButtons=buttons;
        int item = itemType;

       List<Product> list = AppDatabase.getAppDatabase(getContext()).productDao().getProductByType(item);
        ArrayList<String> values = new ArrayList<>();
        for(Product product:list){
            values.add(product.getUrl());
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                        FullScreenFragment fullScreenFragment = FullScreenFragment.newInstance(urlStrings[mPosition]);
                        AppCompatActivity activity = (AppCompatActivity) view.getContext();
                        activity.getSupportFragmentManager().beginTransaction().add(R.id.content, fullScreenFragment).addToBackStack(null).commit();
            }
        });
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            Toast.makeText(context,"Item Fragment", Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private void collection(String[] s){
        urlStrings=s;
        picasso();
    }


    private void picasso(){
        //0Glide.with(this).load(gg[mPosition]).into(holderImageView);
        Picasso.with(getContext()).load(urlStrings[mPosition]).into(imageView, new com.squareup.picasso.Callback(){
            @Override
            public void onSuccess() {
                pb.setVisibility(View.INVISIBLE);
                buttonsToVisible(urlStrings.length);
            }
            @Override
            public void onError() {

            }
        });

    }


    private void buttonsToVisible(int size){
        for (int i=0; i<size; i++){
            mButtons[i].setVisibility(View.VISIBLE);
        }
    }
}
