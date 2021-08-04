package factory;

/**
 * NYStypleCheesePizza class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class NYStypleCheesePizza extends Pizza {
    public NYStypleCheesePizza() {
        name = "NY Style Sauce and Cheese Pizza";
        //dough = "Thin Crust Dough";
        //sauce = "Marinara Sauce";

        toppings.add("Grated Reggiano Cheese");
    }

    @Override
    void prepare() {

    }
}
