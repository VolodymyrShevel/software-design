package com.patterns.task04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SmartTextReader {
    public char[][] read(String filePath) {
        List<char[]> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line.toCharArray());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + filePath, e);
        }
        return lines.toArray(new char[0][]);
    }
}
