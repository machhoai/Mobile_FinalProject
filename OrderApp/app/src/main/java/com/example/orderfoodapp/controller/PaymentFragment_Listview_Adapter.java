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

import java.util.List;

public class PaymentFragment_Listview_Adapter extends ArrayAdapter<Cart> {
    private Context context;
    private int layout;
    private List<Cart> cartList;
    private TextView totalQuantityTextView;
    private TextView totalAmountTextView;

    public PaymentFragment_Listview_Adapter(Context context, int layout, List<Cart> cartList, TextView totalQuantityTextView, TextView totalAmountTextView) {
        super(context, layout, cartList);
        this.context = context;
        this.layout = layout;
        this.cartList = cartList;
        this.totalQuantityTextView = totalQuantityTextView;
        this.totalAmountTextView = totalAmountTextView;
    }

    @Override
    public int getCount() {
        return cartList.size();
    }

    @Override
    public Cart getItem(int position) {
        return cartList.get(position);
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
            convertView = inflater.inflate(layout, parent, false);

            holder = new ViewHolder();
            holder.productImage = convertView.findViewById(R.id.product_image);
            holder.productName = convertView.findViewById(R.id.product_name);
            holder.productPrice = convertView.findViewById(R.id.product_price);
            holder.productQuantity = convertView.findViewById(R.id.quantityEditText);
            holder.deleteButton = convertView.findViewById(R.id.delete_button);
            holder.quantityDecreaseButton = convertView.findViewById(R.id.decreaseButton);
            holder.quantityIncreaseButton = convertView.findViewById(R.id.increaseButton);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Cart cartItem = getItem(position);
        Product product = cartItem.getProduct();

        // Set the data
        holder.productImage.setImageResource(context.getResources().getIdentifier(product.getImageProduct(), "drawable", context.getPackageName()));
        holder.productName.setText(product.getProduct());
        holder.productPrice.setText(String.format("%,dđ", product.getPrice()));
        holder.productQuantity.setText(String.valueOf(cartItem.getQuantity()));

        holder.quantityDecreaseButton.setOnClickListener(v -> {
            int quantity = cartItem.getQuantity();
            if (quantity > 1) {
                cartItem.setQuantity(quantity - 1);
                updateTotal();
                notifyDataSetChanged();
            }
        });

        holder.quantityIncreaseButton.setOnClickListener(v -> {
            int quantity = cartItem.getQuantity();
            cartItem.setQuantity(quantity + 1);
            updateTotal();
            notifyDataSetChanged();
        });

        holder.deleteButton.setOnClickListener(v -> {
            cartList.remove(position);
            updateTotal();
            notifyDataSetChanged();
        });

        return convertView;
    }

    private void updateTotal() {
        int totalQuantity = 0;
        int totalAmount = 0;
        for (Cart item : cartList) {
            totalQuantity += item.getQuantity();
            totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }
        totalQuantityTextView.setText(String.format("Số lượng: %d", totalQuantity));
        totalAmountTextView.setText(String.format("Tổng cộng: %,dđ", totalAmount));
    }

    private static class ViewHolder {
        ImageButton quantityIncreaseButton;
        ImageButton quantityDecreaseButton;
        ImageView productImage;
        TextView productPrice, productName, productQuantity;
        ImageButton deleteButton;
    }
}
