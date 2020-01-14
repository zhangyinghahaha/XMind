package designpatterns.factory;

/**
 * NYPizzaStore class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class NYPizzaStore extends PizzaStore {
    @Override
    Pizza createPizza(String item) {
        if(item.equals("cheese")) {
            return new NYStypleCheesePizza();
        } else {
            return null;
        }
    }
}
