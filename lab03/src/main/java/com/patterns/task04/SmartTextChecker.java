package com.patterns.task04;

public class SmartTextChecker extends SmartTextReader {
    private final SmartTextReader reader;

    public SmartTextChecker(SmartTextReader reader) { this.reader = reader; }

    @Override
    public char[][] read(String filePath) {
        System.out.println("[Proxy] Opening file: " + filePath);
        char[][] result = reader.read(filePath);
        System.out.println("[Proxy] File read successfully.");
        System.out.println("[Proxy] Closing file: " + filePath);

        int totalChars = 0;
        for (char[] line : result) totalChars += line.length;
        System.out.println("[Proxy] Lines: " + result.length + ", Characters: " + totalChars);

        return result;
    }
}
