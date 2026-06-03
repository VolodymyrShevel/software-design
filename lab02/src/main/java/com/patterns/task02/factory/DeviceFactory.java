package com.patterns.task02.factory;
import com.patterns.task02.device.Device;
public interface DeviceFactory {
    Device createLaptop();
    Device createNetbook();
    Device createEBook();
    Device createSmartphone();
    default void printAll() {
        System.out.println("=== " + getClass().getSimpleName() + " ===");
        createLaptop().printInfo();
        createNetbook().printInfo();
        createEBook().printInfo();
        createSmartphone().printInfo();
    }
}
