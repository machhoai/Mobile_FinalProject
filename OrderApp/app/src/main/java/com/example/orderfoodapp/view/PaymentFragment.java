package com.example.orderfoodapp.view;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.orderfoodapp.R;
import com.example.orderfoodapp.controller.NetworkUtil;
import com.example.orderfoodapp.controller.PaymentFragment_Listview_Adapter;
import com.example.orderfoodapp.controller.ProductData;
import com.example.orderfoodapp.model.Cart;
import com.example.orderfoodapp.model.Product;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PaymentFragment extends Fragment {

    private ListView orderListView;
    private PaymentFragment_Listview_Adapter adapter;
    private List<Product> products;
    private TextView totalQuantityTextView;
    private TextView totalAmountTextView;
    private Button confirmPayment;
    private ImageView qrCodeImageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);

        // Khởi tạo danh sách các sản phẩm mẫu
        products = ProductData.getSampleProducts();

        List<Cart> cart = new ArrayList<>();
        for (Product product : products) {
            cart.add(new Cart(product, 2));
        }



        // Thiết lập ListView và Adapter
        orderListView = view.findViewById(R.id.order_list);
        totalQuantityTextView = view.findViewById(R.id.total_quantity);
        totalAmountTextView = view.findViewById(R.id.total_amount);
        adapter = new PaymentFragment_Listview_Adapter(getContext(), R.layout.item_order, cart, totalQuantityTextView, totalAmountTextView);
        orderListView.setAdapter(adapter);
        confirmPayment = view.findViewById(R.id.confirm_payment_button);
        qrCodeImageView = view.findViewById(R.id.qrCodeImageView);
        updateTotal(cart);
        showQRCode();
        handleConfirmPaymentBtnClick();
        return view;
    }

    private void handleConfirmPaymentBtnClick() {
        confirmPayment.setOnClickListener(v -> {
            new AlertDialog.Builder(getContext())
                    .setTitle("Xác nhận thanh toán")
                    .setMessage("Bạn có chắc chắn muốn thanh toán không?")
                    .setPositiveButton("Xác nhận", (dialog, which) -> showQRCode())
                    .setNegativeButton("Hủy", null)
                    .show();
        });
    }

    private void showQRCode() {
        // URL của hình ảnh QR code
        String qrCodeUrl = "https://img.vietqr.io/image/mbbank-5411122004-compact2.jpg?amount=1000&addInfo=dong%20qop%20quy%20vac%20xin&accountName=Mach%20Lam%20Quoc%20Hoai";
        Log.d("Show qr code", "showQRCode: " + qrCodeUrl);
        boolean nw = NetworkUtil.isNetworkAvailable(getContext());
        Log.d("Network", "showQRCode: " + nw);
        // Hiển thị ImageView và tải hình ảnh QR code
        loadImageWithRetry(qrCodeUrl, 3); // Thử tải lại hình ảnh tối đa 3 lần
    }

    private void loadImageWithRetry(String url, int retryCount) {
        Picasso.get().load(url).into(qrCodeImageView, new Callback() {
            @Override
            public void onSuccess() {
                Log.d("Picasso", "Image loaded successfully");
            }

            @Override
            public void onError(Exception e) {
                Log.e("Picasso", "Error loading image", e);
                if (retryCount > 0) {
                    Log.d("Picasso", "Retrying... (" + retryCount + " attempts left)");
                    loadImageWithRetry(url, retryCount - 1);
                }
            }
        });
    }

    private void updateTotal(List<Cart> cartList) {
        int totalQuantity = 0;
        int totalAmount = 0;
        for (Cart item : cartList) {
            totalQuantity += item.getQuantity();
            totalAmount += item.getProduct().getPrice() * item.getQuantity();
        }
        totalQuantityTextView.setText(String.format("Số lượng: %d", totalQuantity));
        totalAmountTextView.setText(String.format("Tổng cộng: %,dđ", totalAmount));
    }
}
