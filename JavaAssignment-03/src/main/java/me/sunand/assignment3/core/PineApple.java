package me.sunand.assignment3.core;
public class PineApple extends Product {
    PineApple() {
       super("GROCERY",50,100);
    }

    public String getColor() {
        return "yellow";
    }

    public String getVitamins() {
        return new StringBuffer().append("A").append(",").append("B6").append(",").append("E").append(",").append("K").toString();
    }
}
