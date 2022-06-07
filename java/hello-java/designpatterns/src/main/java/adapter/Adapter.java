package adapter;

/**
 * @author ying.zhang01
 */
public class Adapter implements Target{
    private Adaptee adaptee;

    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        System.out.println("适配方法");
        this.adaptee.specificRequest();
    }
}
