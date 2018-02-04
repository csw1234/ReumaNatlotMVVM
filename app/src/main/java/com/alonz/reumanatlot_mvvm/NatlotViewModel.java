package com.alonz.reumanatlot_mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.alonz.reumanatlot_mvvm.Database.AppDatabase;
import com.alonz.reumanatlot_mvvm.Database.Product;

import java.util.List;

/**
 * Created by alonz on 28/01/2018.
 */

public class NatlotViewModel extends AndroidViewModel {
    private LiveData<List<Product>> mList;
    private NatlotRepository natlotRepository = new NatlotRepository(this.getApplication());

    public NatlotViewModel(Application application) {
        super(application);
        natlotRepository.getNatlot();
        mList = AppDatabase.getAppDatabase(application).productDao().getAll();
    }

    public LiveData<List<Product>> getNatlotList(){
        return mList;
    }
}
