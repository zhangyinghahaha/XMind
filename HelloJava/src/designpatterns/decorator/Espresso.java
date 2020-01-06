package designpatterns.decorator;

/**
 * Espresso class
 *
 * @author ying.zhang01
 * @date 2019/12/30
 */
public class Espresso extends Beverage {

    public Espresso() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
