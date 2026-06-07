package com.patterns.task06;

import com.patterns.task05.*;
import java.util.List;

public class BookParser {

    public static LightElementNode parse(String text) {
        String[] lines = text.split("\n");
        LightElementNode root = new LightElementNode(
                "div",
                LightElementNode.DisplayType.BLOCK,
                LightElementNode.ClosingType.WITH_CLOSING_TAG,
                List.of("book")
        );

        boolean firstLine = true;
        for (String line : lines) {
            if (line.isBlank()) continue;

            LightElementNode element;
            if (firstLine) {
                element = LightElementFactory.getElement(
                        "h1",
                        LightElementNode.DisplayType.BLOCK,
                        LightElementNode.ClosingType.WITH_CLOSING_TAG,
                        List.of());
                firstLine = false;
            } else if (line.length() < 20) {
                element = LightElementFactory.getElement(
                        "h2",
                        LightElementNode.DisplayType.BLOCK,
                        LightElementNode.ClosingType.WITH_CLOSING_TAG,
                        List.of());
            } else if (line.startsWith(" ") || line.startsWith("\t")) {
                element = LightElementFactory.getElement(
                        "blockquote",
                        LightElementNode.DisplayType.BLOCK,
                        LightElementNode.ClosingType.WITH_CLOSING_TAG,
                        List.of());
            } else {
                element = LightElementFactory.getElement(
                        "p",
                        LightElementNode.DisplayType.BLOCK,
                        LightElementNode.ClosingType.WITH_CLOSING_TAG,
                        List.of());
            }

            // Each element needs its own text child (extrinsic state)
            LightElementNode wrapper = new LightElementNode(
                    element.toString().split("<")[1].split(">")[0].split(" ")[0],
                    LightElementNode.DisplayType.BLOCK,
                    LightElementNode.ClosingType.WITH_CLOSING_TAG,
                    List.of()
            );
            wrapper.addChild(new LightTextNode(line.trim()));
            root.addChild(wrapper);
        }
        return root;
    }

    public static long estimateMemory(LightElementNode root) {
        return countNodes(root) * 200L;
    }

    private static int countNodes(LightNode node) {
        if (node instanceof LightTextNode) return 1;
        if (node instanceof LightElementNode el) {
            int count = 1;
            for (int i = 0; i < el.getChildCount(); i++) count++;
            return count;
        }
        return 1;
    }
}
