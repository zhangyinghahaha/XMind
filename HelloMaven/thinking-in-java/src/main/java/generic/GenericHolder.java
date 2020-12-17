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
    public void set(T a) {
        this.a = a;
    }
    public T get() {return a;}

    public static void main(String[] args) {
        GenericHolder h3 = new GenericHolder();
        h3.set(new Automobile());
        //Automobile a = h3.get();
        //h3.set("Not an Automobile");
        System.out.println(h3.get());
    }
}
