package com.example.orderfoodapp.controller;

import com.example.orderfoodapp.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductData {
    public static List<Product> getSampleProducts() {
        List<Product> products = new ArrayList<>();

        products.add(new Product("1", "burgerbo", "Burger bò", 75000, 0.1f, false, "bo, banhmi, rau, sot", "MonChinh"));
        products.add(new Product("2", "burgerga", "Burger gà", 70000, 0.1f, false, "ga, banhmi, rau, sot", "MonChinh"));
        products.add(new Product("3", "burgerchay", "Burger chay", 60000, 0.1f, false, "rau, banhmi, sot", "MonChinh"));
        products.add(new Product("4", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        products.add(new Product("5", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        products.add(new Product("6", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        products.add(new Product("7", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        products.add(new Product("8", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        products.add(new Product("9", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        products.add(new Product("10", "my", "Mỳ Ý Spaghetti", 80000, 0.1f, false, "my, thit bo, sot", "MonChinh"));
        return products;
    }
}
