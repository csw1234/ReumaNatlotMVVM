package com.alonz.reumanatlot_mvvm;

import com.alonz.reumanatlot_mvvm.Database.Product;
import com.alonz.reumanatlot_mvvm.Firebase.FirebaseInterface;
import com.alonz.reumanatlot_mvvm.Firebase.FirebaseListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;


/**
 * Created by alonz on 28/01/2018.
 */

public class NatlotRepository  implements FirebaseInterface {

    private HashMap<String, ArrayList<String>> natlot;
    private FirebaseListener mFirebase = new FirebaseListener(this);
    private ArrayList<String> mData;


    public void getRed(){
        mFirebase.getNatlot();

    }

    @Override
    public void natlotReady(HashMap<String, ArrayList<String>> natlot) {
        this.natlot=natlot;
        Collection<ArrayList<String>> ss = this.natlot.values();
        int index = 0;
        for (ArrayList<String> s:ss){
          createProduct(0, s.get(0),index);
          index++;
        }

    }

    private void createProduct(int type, String url, int color){
        Product product = new Product();
        product.setUrl(url);
        product.setColor(color);
        product.setType(type);
    }

}
