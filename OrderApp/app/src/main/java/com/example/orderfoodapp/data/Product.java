package com.example.orderfoodapp.data;

public class Product {
    String id;
    String imageProduct;
    String product;
    int price;
    float sale;
    Boolean trending;
    String ingredient;
    String classify;

    public Product(){

    }
    public Product(String id, String imageProduct, String product, int price, float sale, Boolean trending, String ingredient, String classify) {
        this.id = id;
        this.imageProduct = imageProduct;
        this.product = product;
        this.price = price;
        this.sale = sale;
        this.trending = trending;
        this.ingredient = ingredient;
        this.classify = classify;
    }

    public String getId() {
        return id;
    }

    public String getImageProduct() {
        return imageProduct;
    }

    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public float getSale() {
        return sale;
    }

    public Boolean getTrending() {
        return trending;
    }

    public String getIngredient() {
        return ingredient;
    }

    public String getClassify() {
        return classify;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImageProduct(String imageProduct) {
        this.imageProduct = imageProduct;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSale(float sale) {
        this.sale = sale;
    }

    public void setTrending(Boolean trending) {
        this.trending = trending;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }
}
