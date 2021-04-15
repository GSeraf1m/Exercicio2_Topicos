package com.example.exercicio2serafim.model;

import java.util.ArrayList;

public class ProductListResponse {
    private ArrayList<Product> products;

    public ProductListResponse() {
    }

    public ProductListResponse(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}
