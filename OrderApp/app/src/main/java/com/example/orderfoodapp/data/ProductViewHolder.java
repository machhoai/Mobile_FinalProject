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
        imageProduct = itemView.findViewById(R.id.image);
        productName = itemView.findViewById(R.id.Name);
        productPrice = itemView.findViewById(R.id.Price);
        productSale = itemView.findViewById(R.id.Sale);
        productIngredient = itemView.findViewById(R.id.Ingredient);
    }
}
