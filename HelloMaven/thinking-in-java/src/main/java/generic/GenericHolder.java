package generic;

/**
 * GenericHolder class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class GenericHolder<T> {
    private T a;
    public GenericHolder() {}
    public GenericHolder(T a) {
        this.a = a;
    }
    public void set(T a) {
        this.a = a;
    }
    public T get() {return a;}

    public static void main(String[] args) {
        GenericHolder<String> h3 = new GenericHolder(new Automobile());
        // h3.set(new Automobile());
        String a = h3.get();
        // h3.set("Not an Automobile");
        System.out.println(a);
    }
}
