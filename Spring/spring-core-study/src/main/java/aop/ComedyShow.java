package aop;

import org.springframework.stereotype.Component;

@Component
public class ComedyShow implements Performance{
    @Override
    public void perform() {
        throw new RuntimeException("can not perform!");
        // System.out.println("Comedy Show!!!");
    }

    @Override
    public void perform(String name) {
        System.out.println("Comedy show: " + name);
    }
}
