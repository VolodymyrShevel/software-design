package com.patterns.task05;

import java.util.ArrayList;
import java.util.List;

public class LightElementNode extends LightNode {

    public enum DisplayType  { BLOCK, INLINE }
    public enum ClosingType  { SELF_CLOSING, WITH_CLOSING_TAG }

    private final String tag;
    private final DisplayType displayType;
    private final ClosingType closingType;
    private final List<String> cssClasses;
    private final List<LightNode> children = new ArrayList<>();

    public LightElementNode(String tag, DisplayType displayType,
                            ClosingType closingType, List<String> cssClasses) {
        this.tag         = tag;
        this.displayType = displayType;
        this.closingType = closingType;
        this.cssClasses  = cssClasses;
    }

    public LightElementNode addChild(LightNode node) { children.add(node); return this; }
    public int getChildCount() { return children.size(); }

    private String buildOpeningTag() {
        StringBuilder sb = new StringBuilder("<").append(tag);
        if (!cssClasses.isEmpty()) {
            sb.append(" class=\"").append(String.join(" ", cssClasses)).append("\"");
        }
        if (closingType == ClosingType.SELF_CLOSING) sb.append("/");
        sb.append(">");
        return sb.toString();
    }

    @Override
    public String innerHTML() {
        if (closingType == ClosingType.SELF_CLOSING) return "";
        StringBuilder sb = new StringBuilder();
        for (LightNode child : children) sb.append(child.outerHTML());
        return sb.toString();
    }

    @Override
    public String outerHTML() {
        if (closingType == ClosingType.SELF_CLOSING) return buildOpeningTag();
        return buildOpeningTag() + innerHTML() + "</" + tag + ">";
    }

    @Override
    public String toString() {
        return String.format("<%s> [%s, %s, classes=%s, children=%d]",
                tag, displayType, closingType, cssClasses, children.size());
    }
}
