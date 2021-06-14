package me.sunand.assignment3.core;

public class Samsung extends Product {
    Samsung() {
        super("ELECTRONICS", 1000, 10);
    }

    public String getNetwork() {
        return "4G";
    }

    public String getBattery() {
        return "lithium-ion";
    }

    public String getCamera() {
        return "41 megapixels";
    }
}
