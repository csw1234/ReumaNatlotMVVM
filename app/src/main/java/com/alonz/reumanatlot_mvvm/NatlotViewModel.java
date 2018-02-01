package com.alonz.reumanatlot_mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;

import com.alonz.reumanatlot_mvvm.Database.AppDatabase;
import com.alonz.reumanatlot_mvvm.Database.Product;

/**
 * Created by alonz on 28/01/2018.
 */

public class NatlotViewModel extends AndroidViewModel {

    private NatlotRepository natlotRepository = new NatlotRepository();

    public NatlotViewModel(Application application) {
        super(application);
        natlotRepository.getRed();

        Product product = new Product();
        product.setUrl("www");
        product.setColor(0);
        product.setType(0);

        AppDatabase.getAppDatabase(application).natlaDao().insert(product);
    }
}
