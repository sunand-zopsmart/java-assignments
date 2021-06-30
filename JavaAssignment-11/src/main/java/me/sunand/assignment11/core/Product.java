package me.sunand.assignment11.core;

public class Product {
    int productID,cost,quantity;
    String productName;

    Product(int productID,String productName, int cost, int quantity) {
        this.productID = productID;
        this.cost = cost;
        this.quantity = quantity;
        this.productName=productName;
    }

    public int getProductID() {
        return this.productID;
    }

    public int getCost() {
        return this.cost;
    }

    public int getQuantity() {
        return this.quantity;
    }
    public String getProductName(){
        return this.productName;
    }
}
