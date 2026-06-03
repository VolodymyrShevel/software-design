package com.patterns.task01.creator;
import com.patterns.task01.subscription.*;
public class ManagerCall extends SubscriptionCreator {
    @Override public Subscription createDomestic()     { System.out.println("[ManagerCall] Manager creating Domestic subscription by phone..."); return new DomesticSubscription(); }
    @Override public Subscription createEducational()  { System.out.println("[ManagerCall] Manager creating Educational subscription by phone..."); return new EducationalSubscription(); }
    @Override public Subscription createPremium()      { System.out.println("[ManagerCall] Manager creating Premium subscription by phone (VIP service)..."); return new PremiumSubscription(); }
}
