package com.patterns.task02.factory;
import com.patterns.task02.device.Device;
import com.patterns.task02.product.*;
public class IProneFactory implements DeviceFactory {
    @Override public Device createLaptop()     { return new IProneLaptop(); }
    @Override public Device createNetbook()    { return new IProneNetbook(); }
    @Override public Device createEBook()      { return new IProneEBook(); }
    @Override public Device createSmartphone() { return new IProneSmartphone(); }
}
