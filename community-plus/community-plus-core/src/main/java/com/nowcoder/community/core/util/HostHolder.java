package com.nowcoder.community.core.util;

import org.springframework.stereotype.Component;

/**
 * 持有用户信息，用于代替session对象
 * @author ying.zhang01
 */
@Component
public class HostHolder<E> {
    private ThreadLocal<E> userThreadLocal = new ThreadLocal<>();

    public void setUser(E user) {
        userThreadLocal.set(user);
    }

    public E getUser() {
        return userThreadLocal.get();
    }

    public void remove() {
        userThreadLocal.remove();
    }
}
