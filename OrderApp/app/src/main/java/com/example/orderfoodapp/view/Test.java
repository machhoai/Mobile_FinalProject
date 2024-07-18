package com.example.orderfoodapp.view;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.orderfoodapp.R;
import com.example.orderfoodapp.controller.NetworkUtil;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class Test extends AppCompatActivity {
    ImageView qrCodeImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        qrCodeImageView = findViewById(R.id.ImgTest);
        showQRCode();
    }

    private void showQRCode() {
        // URL của hình ảnh QR code
        String qrCodeUrl = "https://img.vietqr.io/image/mbbank-5411122004-compact2.jpg?amount=1000&addInfo=dong%20qop%20quy%20vac%20xin&accountName=Mach%20Lam%20Quoc%20Hoai";
        Log.d("Show qr code", "showQRCode: " + qrCodeUrl);
//        boolean nw = NetworkUtil.isNetworkAvailable(this);
//        Log.d("Network", "showQRCode: " + nw);
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
}