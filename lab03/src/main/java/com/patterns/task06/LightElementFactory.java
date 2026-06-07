package com.patterns.task06;

import com.patterns.task05.LightElementNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Flyweight Factory: reuses LightElementNode instances with same tag+classes.
 * Intrinsic state: tag, displayType, closingType, cssClasses.
 * Extrinsic state: children (added per use).
 */
public class LightElementFactory {
    private static final Map<String, LightElementNode> cache = new HashMap<>();

    public static LightElementNode getElement(String tag,
                                               LightElementNode.DisplayType display,
                                               LightElementNode.ClosingType closing,
                                               List<String> classes) {
        String key = tag + display + closing + classes;
        return cache.computeIfAbsent(key, k ->
                new LightElementNode(tag, display, closing, classes));
    }

    public static int getCacheSize() { return cache.size(); }
}
