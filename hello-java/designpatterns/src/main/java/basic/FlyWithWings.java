package basic;

/**
 * FlyWithWings class
 *
 * @author zhangying
 * @date 2019/6/25
 */
public class FlyWithWings implements FlyBehavior {
    @Override
    public void fly() {
        System.out.println("I'm flying!");
    }
}
