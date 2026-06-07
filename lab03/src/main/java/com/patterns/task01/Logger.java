package com.patterns.task01;

public class Logger {
    public static final String RESET  = "\u001B[0m";
    public static final String GREEN  = "\u001B[32m";
    public static final String RED    = "\u001B[31m";
    public static final String ORANGE = "\u001B[33m";

    public void log(String message)   { System.out.println(GREEN  + "[LOG]   " + message + RESET); }
    public void error(String message) { System.out.println(RED    + "[ERROR] " + message + RESET); }
    public void warn(String message)  { System.out.println(ORANGE + "[WARN]  " + message + RESET); }
}
