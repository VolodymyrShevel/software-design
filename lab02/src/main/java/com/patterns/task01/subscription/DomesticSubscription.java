package com.patterns.task01.subscription;
import java.util.List;
public class DomesticSubscription extends AbstractSubscription {
    public DomesticSubscription() {
        super(99.0, 1, List.of("UA:Pershyi", "UA:Kultura", "UA:Sport", "SD quality"));
    }
}
