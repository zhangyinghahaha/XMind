package generic;

import unit9.A;

import java.util.ArrayList;
import java.util.List;

class Plate<T> {
    private T item;
    public Plate(T t) {
        this.item = t;
    }
    public void set(T t) {
        this.item = t;
    }
    public T get() {
        return this.item;
    }
}

//Lev 1
class Food{
    private String name;
    public String getName() {
        return this.name;
    }
}

//Lev 2
class Fruit extends Food{}
class Meat extends Food{}

//Lev 3
class Apple extends Fruit{
    private String name = "Apple";
}
class Banana extends Fruit{}
class Pork extends Meat{}
class Beef extends Meat{}

//Lev 4
class RedApple extends Apple{}

public class Fruit2 {
    public static void inspect(Plate<Object> plate) {
        System.out.println(plate.get());
    }

    public static void main(String[] args) {
        System.out.println(new Apple().getName());
        Plate<? extends Fruit> p = new Plate<Apple>(new Apple());
        //p.set(new Apple());
        Fruit f = p.get();

        Plate<? super Fruit> p2 = new Plate<>(new Food());
        p2.set(new Apple());
    }
}
