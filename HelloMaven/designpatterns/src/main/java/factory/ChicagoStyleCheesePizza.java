package factory;

/**
 * ChicagoStyleCheesePizza class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class ChicagoStyleCheesePizza extends Pizza {
    public ChicagoStyleCheesePizza() {
        name = "Chicago Style Deep Dish Cheese Pizza";
        //dough = "Extra Thick Crust Dough";
        //sauce = "Plum Tomato Sauce";

        toppings.add("Shredded Mozzarella Cheese");
    }

    @Override
    void prepare() {
    }

    @Override
    void cut() {
        System.out.println("Cutting the pizza into square slices");
    }
}
