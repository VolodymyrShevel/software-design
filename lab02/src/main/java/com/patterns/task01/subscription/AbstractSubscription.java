package com.patterns.task01.subscription;

import java.util.List;

public abstract class AbstractSubscription implements Subscription {
    protected final double monthlyFee;
    protected final int minPeriodMonths;
    protected final List<String> features;

    protected AbstractSubscription(double monthlyFee, int minPeriodMonths, List<String> features) {
        this.monthlyFee = monthlyFee;
        this.minPeriodMonths = minPeriodMonths;
        this.features = features;
    }

    @Override public double getMonthlyFee()      { return monthlyFee; }
    @Override public int    getMinPeriodMonths() { return minPeriodMonths; }
    @Override public List<String> getFeatures()  { return features; }

    @Override
    public void printInfo() {
        System.out.println("=== " + getClass().getSimpleName() + " ===");
        System.out.printf("  Monthly fee  : %.2f UAH%n", monthlyFee);
        System.out.println("  Min period   : " + minPeriodMonths + " months");
        System.out.println("  Features     : " + features);
    }
}
