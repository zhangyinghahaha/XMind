package factory;

/**
 * PizzaIngredientFactory interface
 *
 * @author ying.zhang01
 * @date 2020/1/15
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Veggies[] createVeggies();
    Pepperoni createPepperoni();
    Clams createClams();
}
