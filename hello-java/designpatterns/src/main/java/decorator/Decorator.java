package decorator;

/**
 * @author ying.zhang01
 */
public abstract class Decorator implements Component{
    Component wrappedComponent;

    public Decorator(Component wrappedComponent) {
        this.wrappedComponent = wrappedComponent;
    }

    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.methodA();

        System.out.println();

        component = new ConcreteDecoratorA(component);
        component.methodA();

        System.out.println();

        component = new ConcreteDecoratorB(component);
        component.methodA();
    }
}
