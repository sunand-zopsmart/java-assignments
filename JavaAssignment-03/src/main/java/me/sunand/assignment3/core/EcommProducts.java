package me.sunand.assignment3.core;
public class EcommProducts {
    public static void main(String[] args) {
        Product[] products = new Product[]{
                new PineApple(),
                new Samsung(),
                new Shampoo()
        };
        System.out.println("Details of various products");
        for (Product product : products) {
            System.out.println("Product Name: " + product.getClass().getSimpleName());
            System.out.println("Per Unit Cost: " + product.getCost());
            System.out.println("Quantity Available: " + product.getQuantity());
            if (product instanceof PineApple) {
                System.out.println("Colour: " + new PineApple().getColor());
                System.out.println("Vitamins: " + new PineApple().getVitamins());
            } else if (product instanceof Samsung) {
                System.out.println("Network: " + new Samsung().getNetwork());
                System.out.println("Battery: " + new Samsung().getBattery());
                System.out.println("Camera: " + new Samsung().getCamera());
            } else {
                System.out.println("Brand: " + new Shampoo().getBrand());
                System.out.println("pH: " + new Shampoo().getpH());
            }
        }
    }
}













