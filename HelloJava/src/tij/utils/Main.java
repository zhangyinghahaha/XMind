package tij.utils;

import tij.unit10.Animal;
import tij.unit9.Months;

/**
 * Main class
 *
 * @author ying.zhang01
 * @date 2019/4/8
 */
public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("xiaobai");
        Animal.Dog dog = animal.new Dog();
        System.out.println(dog);
    }
}
