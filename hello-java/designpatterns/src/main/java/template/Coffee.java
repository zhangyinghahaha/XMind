package template;

/**
 * @author ying.zhang01
 */
public class Coffee extends CaffeineBeverage{

    @Override
    void brew() {
        System.out.println("Dripping Coffer through filter");
    }

    @Override
    void addCondiments() {
        System.out.println("Adding Sugar and Milk");
    }
}
