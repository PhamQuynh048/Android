package com.example.phamthingocquynh.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.phamthingocquynh.entity.Product;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface ProductDAO {

    @Insert(onConflict = REPLACE)
    void insertProduct(Product product);

    @Update
    void updateProduct(Product product);

    @Delete
    void deleteProduct(Product product);

    @Query("SELECT * FROM Product")
    List<Product> getAllProduct();

}
