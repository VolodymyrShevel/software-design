package com.patterns.task03;
public class Authenticator {
    private static volatile Authenticator instance;
    private String currentUser = null;
    private Authenticator() {}
    public static Authenticator getInstance() {
        if (instance == null) { synchronized (Authenticator.class) { if (instance == null) instance = new Authenticator(); } }
        return instance;
    }
    public boolean login(String username, String password) {
        if ("admin".equals(username) && "1234".equals(password)) {
            this.currentUser = username;
            System.out.println("[Authenticator] User '" + username + "' logged in.");
            return true;
        }
        System.out.println("[Authenticator] Invalid username or password.");
        return false;
    }
    public void logout() { System.out.println("[Authenticator] User '" + currentUser + "' logged out."); this.currentUser = null; }
    public boolean isLoggedIn() { return currentUser != null; }
    public String getCurrentUser() { return currentUser; }
}
