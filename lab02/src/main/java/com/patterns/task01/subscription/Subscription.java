package com.patterns.task01.subscription;

import java.util.List;

public interface Subscription {
    double getMonthlyFee();
    int getMinPeriodMonths();
    List<String> getFeatures();
    void printInfo();
}
