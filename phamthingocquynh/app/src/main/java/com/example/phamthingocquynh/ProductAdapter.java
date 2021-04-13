package com.example.phamthingocquynh;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phamthingocquynh.entity.Product;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter {

    private Activity activity;
    private List<Product> listProduct;

    public ProductAdapter(Activity activity, List<Product> listProduct){
        this.activity = activity;
        this.listProduct = listProduct;
    }

    public class ProductHolder extends RecyclerView.ViewHolder{

        TextView tvId, tvName, tvQuantity;

        public ProductHolder(@NonNull View itemView) {
            super(itemView);
            tvId = itemView.findViewById(R.id.tvId);
            tvName = itemView.findViewById(R.id.tvName);
            tvQuantity = itemView.findViewById(R.id.tvQuantity);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = activity.getLayoutInflater().inflate(R.layout.item_product,parent,false);
        ProductHolder holder = new ProductHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ProductHolder user = (ProductHolder) holder;
        Product model = listProduct.get(position);
        user.tvId.setText(String.valueOf(model.getId()));
        user.tvName.setText(model.getName());
        user.tvQuantity.setText(String.valueOf(model.getQuantity()));
    }
    @Override
    public int getItemCount() {
        return listProduct.size();
    }
}
