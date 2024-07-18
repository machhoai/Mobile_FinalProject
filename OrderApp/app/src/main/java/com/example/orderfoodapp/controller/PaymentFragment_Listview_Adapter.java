package com.example.orderfoodapp.controller;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orderfoodapp.R;
import com.example.orderfoodapp.model.Cart;
import com.example.orderfoodapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class PaymentFragment_Listview_Adapter extends ArrayAdapter<Cart> {
    private Context context;
    private int layout;
    private ArrayList<Cart> listOrder;

    public PaymentFragment_Listview_Adapter(Context context, int layout, ArrayList<Cart> listOrder) {
        super(context, layout);
        this.context = context;
        this.layout = layout;
        this.listOrder = listOrder;
    }

    @Override
    public int getCount() {
        return listOrder.size();
    }

    @Override
    public Cart getItem(int position) {
        return listOrder.get(position);
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
            holder.order_product_name = convertView.findViewById(R.id.order_product_name);
            holder.productPrice = convertView.findViewById(R.id.product_price);
            holder.productIngredient = convertView.findViewById(R.id.product_ingredient);
            holder.deleteButton = convertView.findViewById(R.id.delete_button);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cart cartItem = listOrder.get(position);

        // Set the data
        holder.productImage.setImageResource(context.getResources().getIdentifier(cartItem.getProduct().getImageProduct(), "drawable", context.getPackageName()));
        holder.order_product_name.setText(cartItem.getProduct().getProduct());
        holder.productPrice.setText(String.format("%,dđ", cartItem.getProduct().getPrice()));
        holder.productIngredient.setText(cartItem.getProduct().getIngredient());

        holder.deleteButton.setOnClickListener(v -> {
            // Xóa sản phẩm
            listOrder.remove(position);
            notifyDataSetChanged();
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView productImage;
        TextView productPrice, order_product_name, productIngredient;
        ImageButton deleteButton;
    }

}