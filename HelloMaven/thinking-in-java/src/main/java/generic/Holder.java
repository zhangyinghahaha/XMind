package generic;

import jdk.nashorn.internal.runtime.ECMAException;

import java.util.Objects;

public class Holder<T> {
    private T value;

    public Holder() {}

    public Holder(T val) {
        this.value = val;
    }

    public void set(T val) {
        this.value = val;
    }

    public T get() {
        return this.value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Holder && Objects.equals(value, ((Holder)obj).value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);
        Holder<? extends Fruit> fruit = apple;
        Fruit p = fruit.get();
        d = (Apple) fruit.get();

        try {
            //Orange c = (Orange) fruit.get();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
