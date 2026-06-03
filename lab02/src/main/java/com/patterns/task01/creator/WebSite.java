package com.patterns.task01.creator;
import com.patterns.task01.subscription.*;
public class WebSite extends SubscriptionCreator {
    @Override public Subscription createDomestic()     { System.out.println("[WebSite] Creating Domestic subscription via website..."); return new DomesticSubscription(); }
    @Override public Subscription createEducational()  { System.out.println("[WebSite] Creating Educational subscription via website..."); return new EducationalSubscription(); }
    @Override public Subscription createPremium()      { System.out.println("[WebSite] Creating Premium subscription via website (5% web discount applied)..."); return new PremiumSubscription(); }
}
