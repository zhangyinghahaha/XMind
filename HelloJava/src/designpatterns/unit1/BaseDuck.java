package designpatterns.unit1;

/**
 * Duck class
 *
 * @author zhangying
 * @date 2019/6/25
 */
public abstract class BaseDuck {
    FlyBehavior flyBehavior;
    QuackBehavior quackBehavior;

    /**
     * display
     */
    public abstract void display();

    public void performFly() {
        flyBehavior.fly();
    }

    public void performQuack() {
        quackBehavior.quack();
    }
}
