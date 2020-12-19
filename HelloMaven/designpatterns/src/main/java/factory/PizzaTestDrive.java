package factory;

/**
 * PizzaTestDrive class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class PizzaTestDrive {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        Pizza pizza = nyStore.orderPizza("cheese");

    }
}
