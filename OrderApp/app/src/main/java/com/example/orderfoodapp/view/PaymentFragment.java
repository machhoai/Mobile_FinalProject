package com.example.orderfoodapp.view;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.orderfoodapp.R;
import com.example.orderfoodapp.controller.PaymentFragment_Listview_Adapter;
import com.example.orderfoodapp.controller.ProductData;
import com.example.orderfoodapp.model.Product;

import java.util.List;

public class PaymentFragment extends Fragment {

    private ListView orderListView;
    private PaymentFragment_Listview_Adapter adapter;
    private List<Product> products;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        // Khởi tạo danh sách các sản phẩm mẫu
        products = ProductData.getSampleProducts();

        // Thiết lập ListView và Adapter
        orderListView = view.findViewById(R.id.order_list);
        adapter = new PaymentFragment_Listview_Adapter(getContext(), R.layout.item_order, products);
        orderListView.setAdapter(adapter);

        return view; // Return the inflated view, not a new one
    }
}