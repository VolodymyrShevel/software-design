package com.patterns.task01;

public class FileWriter {
    private final StringBuilder buffer = new StringBuilder();
    private final String fileName;

    public FileWriter(String fileName) { this.fileName = fileName; }

    public void write(String text)     { buffer.append(text); }
    public void writeLine(String text) { buffer.append(text).append("\n"); }

    public String getContent() { return buffer.toString(); }
    public String getFileName() { return fileName; }
}
