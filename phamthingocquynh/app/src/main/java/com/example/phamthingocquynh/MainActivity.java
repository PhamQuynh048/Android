package com.example.phamthingocquynh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.phamthingocquynh.databse.ProductDatabase;
import com.example.phamthingocquynh.entity.Product;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ProductDatabase database;
    Button btSave, btView;
    EditText edName, edQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = ProductDatabase.getProductDatabase(this);

        btSave = findViewById(R.id.btSave);
        btView = findViewById(R.id.btView);
        edName = findViewById(R.id.edName);
        edQuantity = findViewById(R.id.edQuantity);

        InitView();

    }

    private void InitView(){
        btSave.setOnClickListener(this);
        btView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btSave:
                SaveProduct();
                break;
            case R.id.btView:
                viewProduct();
                break;
            default:
                break;
        }
    }

    private void viewProduct() {
        Intent view = new Intent(MainActivity.this,ListActivity.class);
        startActivity(view);
    }

    public void SaveProduct(){
        Product product = new Product();
        product.setName(edName.getText().toString());
        product.setQuantity(Integer.valueOf(edQuantity.getText().toString()));
        database.productDAO().insertProduct(product);
    }


}