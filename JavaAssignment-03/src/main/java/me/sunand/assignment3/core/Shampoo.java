package me.sunand.assignment3.core;

public class Shampoo extends Product{

    Shampoo() {
        super("PERSONAL", 10, 10000);
    }

    public String getBrand() {
        return "Pantene";
    }

    public int getpH() {
        return 3;
    }
}
