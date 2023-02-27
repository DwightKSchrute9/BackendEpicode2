package com.godFathersPizza.model;


public class ProductDetails {
    private double price;
    private int calories;

    public ProductDetails(double price, int calories) {
        this.price = price;
        this.calories = calories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
