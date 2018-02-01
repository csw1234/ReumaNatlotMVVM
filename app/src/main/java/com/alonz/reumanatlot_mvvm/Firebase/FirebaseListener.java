package com.alonz.reumanatlot_mvvm.Firebase;

import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by alonz on 28/01/2018.
 */

public class FirebaseListener{
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private HashMap<String, ArrayList<String>> natlot;
    private HashMap<String, String> kidushCups;
    private HashMap<String, String> meyhamim;
    private HashMap<String, String> holders;
    private HashMap<String, String> sakomonim;
    private HashMap<String, String> salt;
    FirebaseInterface natlotListener;

    public FirebaseListener(FirebaseInterface natlotListener) {
        this.natlotListener = natlotListener;
    }

    public void getNatlot() {
        DatabaseReference root = database.getReference("Natlot");
        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                natlot = (HashMap<String, ArrayList<String>>) dataSnapshot.getValue();
                natlotListener.natlotReady(natlot);

            }
            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("Error", "Failed to read value.", error.toException());
            }
        });
    }

    public void closeFirebase(){
        FirebaseDatabase.getInstance().goOffline();
    }
}

