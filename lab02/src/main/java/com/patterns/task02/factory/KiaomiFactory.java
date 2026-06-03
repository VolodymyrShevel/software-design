package com.patterns.task02.factory;
import com.patterns.task02.device.Device;
import com.patterns.task02.product.*;
public class KiaomiFactory implements DeviceFactory {
    @Override public Device createLaptop()     { return new KiaomiLaptop(); }
    @Override public Device createNetbook()    { return new KiaomiNetbook(); }
    @Override public Device createEBook()      { return new KiaomiEBook(); }
    @Override public Device createSmartphone() { return new KiaomiSmartphone(); }
}
