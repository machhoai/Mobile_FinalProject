package com.example.orderfoodapp;

import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.orderfoodapp.data.Product;
import com.example.orderfoodapp.data.ProductAdapter;
import com.example.orderfoodapp.data.ProductHandler;

import java.util.ArrayList;
import java.util.List;

public class FoodFragment extends Fragment {

    private SearchView searchFood;
    private RecyclerView rvFood;
    private List<Product> productList;
    private List<Product> allProduct;
    private ProductHandler productHandler;
    private ProductAdapter productAdapter;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private Handler handler;
    private Runnable searchRunnable;
    private static final long SEARCH_DELAY_MS = 200; // Thời gian chờ 0.2 giây

    public FoodFragment() {
        // Required empty public constructor
    }

    public static FoodFragment newInstance(String param1, String param2) {
        FoodFragment fragment = new FoodFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        productHandler = new ProductHandler(getContext());
        handler = new Handler();
        searchRunnable = new Runnable() {
            @Override
            public void run() {
                performSearch(searchFood.getQuery().toString());
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food, container, false);

        // Initialize search view and recycler view
        searchFood = view.findViewById(R.id.searchFood);
        rvFood = view.findViewById(R.id.rvFood);
        rvFood.setLayoutManager(new LinearLayoutManager(getContext()));

        // Initialize ProductHandler and populate the database
        productHandler = new ProductHandler(getContext());
        productHandler.initData();

        // Get all products
        allProduct = productHandler.getAllProducts();

        // Initialize the adapter and set it to the RecyclerView
        productList = new ArrayList<>(allProduct);
        productAdapter = new ProductAdapter(getContext(), productList);
        rvFood.setAdapter(productAdapter);

        // Setup search view listener
        searchFood.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Not used in this case
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Cancel previous search runnable if still pending
                handler.removeCallbacks(searchRunnable);
                // Start new search runnable after a delay
                handler.postDelayed(searchRunnable, SEARCH_DELAY_MS);
                return true;
            }
        });

        return view;
    }

    private void performSearch(String query) {
        List<Product> filteredProducts = filterProductsByName(query);
        if (filteredProducts.isEmpty()) {
            // Show "No results found" message or handle accordingly
            productList.clear();
            productAdapter.updateData(productList);
            Toast.makeText(getContext(), "Không tìm thấy sản phẩm", Toast.LENGTH_SHORT).show();
        } else {
            // Update RecyclerView with filtered products
            productList.clear();
            productList.addAll(filteredProducts);
            productAdapter.updateData(productList);
        }
    }

    private List<Product> filterProductsByName(String query) {
        List<Product> filteredList = new ArrayList<>();
        for (Product product : allProduct) {
            if (product.getProduct().toLowerCase().contains(query.toLowerCase())) {
                filteredList.add(product);
            }
        }
        return filteredList;
    }
}


