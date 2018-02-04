package com.alonz.reumanatlot_mvvm.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by alonz on 08/12/2017.
 */
@Dao
public interface ProductDao {

    @Query("SELECT * FROM Product")
    LiveData<List<Product>> getAll();

    //@Query("SELECT * FROM Product WHERE id = :id")
    //Product getProductById(int id);

    @Query("SELECT * FROM Product WHERE product_type = :type")
    List<Product> getProductByType(int type);

    @Query("SELECT * FROM Product WHERE product_type = :type AND product_color = :color")
    List<Product> getProductByTypeAndColor(int type,int color);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Product... product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Product product);

    @Delete
    void delete(Product product);

    @Query("DELETE FROM Product")
    void deleteAll();




}
