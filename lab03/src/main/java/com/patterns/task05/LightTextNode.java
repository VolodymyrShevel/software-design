package com.patterns.task05;

public class LightTextNode extends LightNode {
    private final String text;

    public LightTextNode(String text) { this.text = text; }

    @Override public String outerHTML() { return text; }
    @Override public String innerHTML() { return text; }
}
