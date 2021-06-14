package me.sunand.assignment3.core;

public class Product {
    String productType;
    int cost, quantity;
    Product(String productType, int cost, int quantity) {
        this.productType = productType;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getProductType() {
        return productType;
    }

    public int getCost() {
        return this.cost;
    }

    public int getQuantity() {
        return this.quantity;
    }
}
