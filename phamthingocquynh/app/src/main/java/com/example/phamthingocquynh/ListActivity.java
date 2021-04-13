package com.example.phamthingocquynh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.phamthingocquynh.databse.ProductDatabase;
import com.example.phamthingocquynh.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    RecyclerView rvProduct;
    List<Product> listProduct = new ArrayList<>();
    ProductDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        database = ProductDatabase.getProductDatabase(this);

        listProduct = database.productDAO().getAllProduct();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);

        ProductAdapter adapter = new ProductAdapter(this, listProduct);

        rvProduct = findViewById(R.id.rvProduct);
        rvProduct.setLayoutManager(layoutManager);
        rvProduct.setAdapter(adapter);
    }
}