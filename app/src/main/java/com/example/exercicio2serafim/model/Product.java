package com.example.exercicio2serafim.model;

import java.io.Serializable;

import androidx.annotation.NonNull;

public class Product implements Serializable {
    String creationTimestamp;
    String description;
    Boolean enabled;
    int id;
    String imageUrl;
    String name;
    Number price;
    int stockLevel;

    public Product() {
    }

    public Product(String creationTimestamp, String description, Boolean enabled, int id, String imageUrl, String name, Number price, int stockLevel) {
        this.creationTimestamp = creationTimestamp;
        this.description = description;
        this.enabled = enabled;
        this.id = id;
        this.imageUrl = imageUrl;
        this.name = name;
        this.price = price;
        this.stockLevel = stockLevel;
    }

    public String getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(String creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Number getPrice() {
        return price;
    }

    public void setPrice(Number price) {
        this.price = price;
    }

    public int getStockLevel() {
        return stockLevel;
    }

    public void setStockLevel(int stockLevel) {
        this.stockLevel = stockLevel;
    }
}
