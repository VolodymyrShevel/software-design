package com.patterns.task02.device;
public abstract class AbstractDevice implements Device {
    protected final String brand;
    protected final String type;
    protected final String specs;
    protected AbstractDevice(String brand, String type, String specs) {
        this.brand = brand; this.type = type; this.specs = specs;
    }
    @Override public String getBrand() { return brand; }
    @Override public String getType()  { return type; }
    @Override public void printInfo()  { System.out.printf("  [%s %s] %s%n", brand, type, specs); }
}
