package designpatterns.unit1;

/**
 * Quack class
 *
 * @author zhangying
 * @date 2019/6/25
 */
public class Quack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
