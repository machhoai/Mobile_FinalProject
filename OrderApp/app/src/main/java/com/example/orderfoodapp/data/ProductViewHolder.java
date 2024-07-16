package com.example.orderfoodapp.data;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.orderfoodapp.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    ImageView imageProduct;
    TextView productName;
    TextView productPrice;
    TextView productSale;
    TextView productIngredient;

    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        imageProduct = itemView.findViewById(R.id.imageProduct);
        productName = itemView.findViewById(R.id.productName);
        productPrice = itemView.findViewById(R.id.productPrice);
        productSale = itemView.findViewById(R.id.productSale);
        productIngredient = itemView.findViewById(R.id.productIngredient);
    }
}
