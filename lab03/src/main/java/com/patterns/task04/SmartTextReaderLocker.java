package com.patterns.task04;

import java.util.regex.Pattern;

public class SmartTextReaderLocker extends SmartTextReader {
    private final SmartTextReader reader;
    private final Pattern blockedPattern;

    public SmartTextReaderLocker(SmartTextReader reader, String regex) {
        this.reader = reader;
        this.blockedPattern = Pattern.compile(regex);
    }

    @Override
    public char[][] read(String filePath) {
        if (blockedPattern.matcher(filePath).find()) {
            System.out.println("[Locker] Access denied! File matches restricted pattern: " + filePath);
            return new char[0][];
        }
        return reader.read(filePath);
    }
}
