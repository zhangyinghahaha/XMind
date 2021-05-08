package decorator;

/**
 * @author ying.zhang01
 */
public class ConcreteDecoratorB extends Decorator{

    public ConcreteDecoratorB(Component wrappedComponent) {
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
        System.out.println("ConcreteDecorateB new behavior");
    }
}
