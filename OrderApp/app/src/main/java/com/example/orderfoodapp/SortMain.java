package com.example.orderfoodapp;

import android.annotation.SuppressLint;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.orderfoodapp.data.Product;
import com.example.orderfoodapp.data.ProductAdapter;

import java.util.List;

public class SortMain extends AppCompatActivity {
    RecyclerView recycle;
    Spinner spinner;
    SQLiteDatabase db;
    ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sort_main);

        db = openOrCreateDatabase("product_manager.db", MODE_PRIVATE, null);

        recycle= (RecyclerView) findViewById(R.id.recycle);
        recycle.setLayoutManager(new LinearLayoutManager(this));
        loadProducts();
        spinner = findViewById(R.id.spinner);
        setupSpinner();

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = parent.getItemAtPosition(position).toString();
                if (selectedItem.equals("Tên từ Z-A")) {
                    sortByProductDesc();
                } else if (selectedItem.equals("Giá tăng dần")) {
                    sortByPriceAsc();
                } else if (selectedItem.equals("Giá giảm dần")) {
                    sortByPriceDesc();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    private void setupSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.sort_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    private void loadProducts() {
        List<Product> products = ProductSorter.sortbyProductASC(db);
        productAdapter = new ProductAdapter(this,products);
        recycle.setAdapter(productAdapter);
    }
    private void sortByProductDesc() {
        List<Product> sortedProducts = ProductSorter.sortbyProductDesc(db);
        updateRecyclerView(sortedProducts);
    }
    private void sortByPriceAsc() {
        List<Product> sortedProducts = ProductSorter.sortByPriceASC(db);
        updateRecyclerView(sortedProducts);
    }
    private void sortByPriceDesc() {
        List<Product> sortedProducts = ProductSorter.sortByPriceDesc(db);
        updateRecyclerView(sortedProducts);
    }
    @SuppressLint("NotifyDataSetChanged")
    private void updateRecyclerView(List<Product> products) {
        productAdapter.updateData(products);
        productAdapter.notifyDataSetChanged();
    }
}