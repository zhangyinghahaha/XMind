package decorator;

/**
 * HouseBlend class
 *
 * @author ying.zhang01
 * @date 2019/12/30
 */
public class HouseBlend extends Beverage {
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
