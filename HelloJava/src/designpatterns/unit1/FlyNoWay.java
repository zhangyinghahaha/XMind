package designpatterns.unit1;

/**
 * FlyNoWay class
 *
 * @author zhangying
 * @date 2019/6/25
 */
public class FlyNoWay implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I can't fly!");
    }
}
