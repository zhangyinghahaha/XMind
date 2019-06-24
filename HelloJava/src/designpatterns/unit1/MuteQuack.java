package designpatterns.unit1;

/**
 * MuteQuack class
 *
 * @author zhangying
 * @date 2019/6/25
 */
public class MuteQuack implements QuackBehavior {
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
