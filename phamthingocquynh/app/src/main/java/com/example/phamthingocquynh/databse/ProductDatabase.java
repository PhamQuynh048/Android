package com.example.phamthingocquynh.databse;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.phamthingocquynh.dao.ProductDAO;
import com.example.phamthingocquynh.entity.Product;

@Database(entities = {Product.class}, version = 1)
public abstract class ProductDatabase extends RoomDatabase {
    private static ProductDatabase productDatabase;
    public abstract ProductDAO productDAO();

    public static ProductDatabase getProductDatabase(Context context){
        if(productDatabase == null){
            productDatabase = Room.databaseBuilder(context, ProductDatabase.class, "Product").allowMainThreadQueries().build();
        }
        return productDatabase;
    }

}
