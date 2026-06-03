package com.patterns.task01.creator;
import com.patterns.task01.subscription.*;
public class MobileApp extends SubscriptionCreator {
    @Override public Subscription createDomestic()     { System.out.println("[MobileApp] Creating Domestic subscription via app..."); return new DomesticSubscription(); }
    @Override public Subscription createEducational()  { System.out.println("[MobileApp] Creating Educational subscription via app..."); return new EducationalSubscription(); }
    @Override public Subscription createPremium()      { System.out.println("[MobileApp] Creating Premium subscription via app (push notification sent)..."); return new PremiumSubscription(); }
}
