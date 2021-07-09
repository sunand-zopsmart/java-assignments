package me.sunand.assignment13.core;

public class Product {
    int id;
    int cost;
    int quantity;
    String product_name;

    Product(int id, String product_name, int cost, int quantity) {
        this.id = id;
        this.product_name = product_name;
        this.cost = cost;
        this.quantity = quantity;
    }
}