package com.example.orderfoodapp.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import com.example.orderfoodapp.R;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;
    private Context context;

    public ProductAdapter(Context context, List<Product> productList) {
        this.productList = productList;
        this.context = context;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Product product = productList.get(position);

        // Bind product data to the views in item_order layout
        holder.imageProduct.setImageResource(context.getResources().getIdentifier(product.getImageProduct(), "drawable", context.getPackageName()));
        holder.productName.setText(product.getProduct());
        holder.productPrice.setText(String.format("Price: $%.2f", product.getPrice() * (1 - product.getSale())));
        holder.productSale.setText(String.format("Sale: %.0f%%", product.getSale() * 100));
        holder.productIngredient.setText("Ingredients: " + product.getIngredient());
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void updateData(List<Product> newProductList) {
        this.productList = newProductList;
        notifyDataSetChanged();
    }

    static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageProduct;
        TextView productName;
        TextView productPrice;
        TextView productSale;
        TextView productIngredient;

        public ProductViewHolder(View itemView) {
            super(itemView);
            imageProduct = itemView.findViewById(R.id.imageProduct);
            productName = itemView.findViewById(R.id.productName);
            productPrice = itemView.findViewById(R.id.productPrice);
            productSale = itemView.findViewById(R.id.productSale);
            productIngredient = itemView.findViewById(R.id.productIngredient);
        }
    }
}