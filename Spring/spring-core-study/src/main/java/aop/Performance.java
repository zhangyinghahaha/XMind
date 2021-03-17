package aop;

import org.springframework.stereotype.Component;

public interface Performance {
    public void perform();
    public void perform(String name);
}
