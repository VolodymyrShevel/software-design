package com.patterns.task02.factory;
import com.patterns.task02.device.Device;
import com.patterns.task02.product.*;
public class BalaxyFactory implements DeviceFactory {
    @Override public Device createLaptop()     { return new BalaxyLaptop(); }
    @Override public Device createNetbook()    { return new BalaxyNetbook(); }
    @Override public Device createEBook()      { return new BalaxyEBook(); }
    @Override public Device createSmartphone() { return new BalaxySmartphone(); }
}
