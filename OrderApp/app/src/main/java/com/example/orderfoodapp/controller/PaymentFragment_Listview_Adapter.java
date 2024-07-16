package com.example.orderfoodapp.controller;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfoodapp.R;
import com.example.orderfoodapp.model.Product;

import java.util.List;

public class PaymentFragment_Listview_Adapter extends ArrayAdapter<Product> {
    private Context context;
    private int layout;
    private List<Product> productList;

    public PaymentFragment_Listview_Adapter(Context context, int layout, List<Product> productList) {
        super(context, layout, productList);
        this.context = context;
        this.layout = layout;
        this.productList = productList;
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public Product getItem(int position) {
        return productList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.productImage = convertView.findViewById(R.id.product_image);
            holder.productName = convertView.findViewById(R.id.product_name);
            holder.productPrice = convertView.findViewById(R.id.product_price);
            holder.productIngredient = convertView.findViewById(R.id.product_ingredient);
            holder.deleteButton = convertView.findViewById(R.id.delete_button);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Product product = productList.get(position);

        // Set the data
        holder.productImage.setImageResource(context.getResources().getIdentifier(product.getImageProduct(), "drawable", context.getPackageName()));
        holder.productName.setText(product.getProduct());
        holder.productPrice.setText(String.format("%,dđ", product.getPrice()));
        holder.productIngredient.setText(product.getIngredient());

        holder.deleteButton.setOnClickListener(v -> {
            // Xóa sản phẩm
            productList.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView productImage;
        TextView productPrice, productName, productIngredient;
        ImageButton deleteButton;
    }

}

