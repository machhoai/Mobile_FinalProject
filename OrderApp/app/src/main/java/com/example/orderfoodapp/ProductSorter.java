package com.example.orderfoodapp;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.orderfoodapp.data.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductSorter {
    public static List<Product> sortbyProductASC(SQLiteDatabase db) {
        return getSortedProducts(db, "product ASC");
    }
    public static List<Product> sortbyProductDesc(SQLiteDatabase db) {
        return getSortedProducts(db, "product DESC");
    }
    public static List<Product> sortByPriceASC(SQLiteDatabase db) {
        return getSortedProducts(db, "price ASC");
    }
    public static List<Product> sortByPriceDesc(SQLiteDatabase db) {
        return getSortedProducts(db, "price DESC");
    }

    private static List<Product> getSortedProducts(SQLiteDatabase db, String orderBy) {
        List<Product> productList = new ArrayList<>();
        String query = "SELECT * FROM product_manager ORDER BY " + orderBy;
        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") Product product = new Product(
                        cursor.getString(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("imageProduct")),
                        cursor.getString(cursor.getColumnIndex("product")),
                        cursor.getInt(cursor.getColumnIndex("price")),
                        cursor.getFloat(cursor.getColumnIndex("sale")),
                        cursor.getInt(cursor.getColumnIndex("trending")) == 1,
                        cursor.getString(cursor.getColumnIndex("ingredient")),
                        cursor.getString(cursor.getColumnIndex("classify"))
                );
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return productList;
    }
}

