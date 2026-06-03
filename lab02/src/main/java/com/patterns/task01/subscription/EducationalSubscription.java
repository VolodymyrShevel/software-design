package com.patterns.task01.subscription;
import java.util.List;
public class EducationalSubscription extends AbstractSubscription {
    public EducationalSubscription() {
        super(149.0, 3, List.of("Discovery", "National Geographic", "TED Talks", "HD quality", "No ads"));
    }
}
