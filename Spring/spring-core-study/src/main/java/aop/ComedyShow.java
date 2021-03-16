package aop;

import org.springframework.stereotype.Component;

@Component
public class ComedyShow implements Performance{
    @Override
    public void perform() {
        System.out.println("Comedy Show!!!");
    }
}
