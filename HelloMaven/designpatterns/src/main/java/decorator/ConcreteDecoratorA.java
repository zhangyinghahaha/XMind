package decorator;

/**
 * @author ying.zhang01
 */
public class ConcreteDecoratorA extends Decorator{

    public ConcreteDecoratorA(Component wrappedComponent) {
        super(wrappedComponent);
    }

    @Override
    public void methodA() {
        this.wrappedComponent.methodA();
        this.newBehavior();
    }

    @Override
    public void methodB() {

    }

    public void newBehavior() {
        System.out.println("ConcreteDecoratorA new behavior");
    }
}
