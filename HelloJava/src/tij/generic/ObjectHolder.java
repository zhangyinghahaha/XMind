package tij.generic;

/**
 * ObjectHolder class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class ObjectHolder {
    private Object a;
    public ObjectHolder(Object a) {
        this.a = a;
    }
    public void set(Object a) {
        this.a = a;
    }
    public Object get() {
        return a;
    }

    public static void main(String[] args) {
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        Automobile a = (Automobile) h2.get();
        h2.set("Not an Automobile");
        String s = (String) h2.get();
    }
}
