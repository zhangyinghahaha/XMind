package com.demo.core;

import com.demo.entity.User;

public class UserContext {
    private static final ThreadLocal<User> curUser = new ThreadLocal<>();

    public static void add(User user) {
        curUser.set(user);
    }

    public static void remove() {
        curUser.remove();
    }

    public static User getCurrentUser() {
        return curUser.get();
    }
}
