package template;

/**
 * @author ying.zhang01
 */
public abstract class CaffeineBeverage {

    /**
     * 具体方法
     */
    final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 抽象方法
     */
    abstract void brew();
    abstract void addCondiments();

    final void boilWater() {
        System.out.println("Boiling water");
    }

    final void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * hook
     * @return
     */
    boolean customerWantsCondiments() {
        return true;
    }
}
