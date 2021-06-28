package me.sunand.assignment10.core;
public class Product {
    Product(int id,String product_name,int cost,int quantity){
        this.id=id;
        this.product_name=product_name;
        this.cost=cost;
        this.quantity=quantity;
    }
    int id,cost,quantity;
    String product_name;
}
