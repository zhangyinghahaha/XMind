package com.demo.core;

public class UserContext {
    private static final ThreadLocal<String> user = new ThreadLocal<>();

    public static void add(String username) {
        user.set(username);
    }

    public static void remove() {
        user.remove();
    }

    public static String getCurrentUsername() {
        return user.get();
    }
}
