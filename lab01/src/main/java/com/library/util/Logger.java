package com.library.util;

/**
 * Simple console logger. Extracted to follow SRP and allow substitution (DIP).
 */
public class Logger implements ILogger {
    public void info(String message) {
        System.out.println("[INFO]  " + message);
    }

    public void warn(String message) {
        System.out.println("[WARN]  " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }
}
