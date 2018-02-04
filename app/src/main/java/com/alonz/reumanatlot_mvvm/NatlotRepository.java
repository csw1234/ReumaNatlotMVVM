package com.alonz.reumanatlot_mvvm;

import android.content.Context;

import com.alonz.reumanatlot_mvvm.Database.AppDatabase;
import com.alonz.reumanatlot_mvvm.Database.Product;
import com.alonz.reumanatlot_mvvm.Firebase.FirebaseInterface;
import com.alonz.reumanatlot_mvvm.Firebase.FirebaseListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by alonz on 28/01/2018.
 */

public class NatlotRepository  implements FirebaseInterface {

    private HashMap<String, ArrayList<String>> natlot;
    private FirebaseListener mFirebase = new FirebaseListener(this);
    private ArrayList<String> mData;
    private Context mContext;

    public NatlotRepository(Context context) {
        this.mContext = context;
    }

    public void getNatlot(){
        mFirebase.getNatlot();

    }

    @Override
    public void natlotReady(HashMap<String, ArrayList<String>> natlot) {
        this.natlot=natlot;
        Collection<ArrayList<String>> natlotCollection = this.natlot.values();
        int index = 0;
        for (ArrayList<String> natlotList:natlotCollection){
            for(String natla:natlotList) {
                int serialNumber = getSerialNumber(natla);
                createProduct(0, natla, index, serialNumber);
            }
            index++;
        }
    }


    private void createProduct(int type, String url, int color, int serialNumber){
        Product product = new Product();
        product.setUrl(url);
        product.setColor(color);
        product.setType(type);
        product.setSerialNumber(serialNumber);
        AppDatabase.getAppDatabase(mContext).productDao().insert(product);

    }

    private int getSerialNumber(String url){
        Pattern pattern = Pattern.compile("(reuma+?)-(\\w+?).jpg?");
        Matcher matcher = pattern.matcher(url);
        String key = "11111";
        if (matcher.find()){
            key  = matcher.group(2);}
        int serial = Integer.valueOf(key);
        return 334*serial;
    }
}
