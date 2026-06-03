package com.patterns.task01.subscription;
import java.util.List;
public class PremiumSubscription extends AbstractSubscription {
    public PremiumSubscription() {
        super(299.0, 6, List.of("All channels", "4K quality", "No ads", "4 devices simultaneously", "Offline viewing"));
    }
}
