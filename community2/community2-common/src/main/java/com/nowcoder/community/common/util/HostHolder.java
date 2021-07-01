package com.nowcoder.community.common.util;

import com.nowcoder.community.domain.entity.User;
import org.springframework.stereotype.Component;

/**
 * 持有用户信息，用于代替session对象
 * @author ying.zhang01
 */
@Component
public class HostHolder {
    private ThreadLocal<User> userThreadLocal = new ThreadLocal<>();

    public void setUser(User user) {
        userThreadLocal.set(user);
    }

    public User getUser() {
        return userThreadLocal.get();
    }

    public void remove() {
        userThreadLocal.remove();
    }
}
