package com.patterns.task01.creator;
import com.patterns.task01.subscription.Subscription;
public abstract class SubscriptionCreator {
    public abstract Subscription createDomestic();
    public abstract Subscription createEducational();
    public abstract Subscription createPremium();
    public void printAllSubscriptions() {
        System.out.println(">> " + getClass().getSimpleName() + " offers:");
        createDomestic().printInfo();
        createEducational().printInfo();
        createPremium().printInfo();
    }
}
