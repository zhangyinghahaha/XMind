package tij.unit10;

/**
 * Parcel11 class
 *
 * @author ying.zhang01
 * @date 2019/4/19
 */
public class Parcel11 {
    public class Dog {
        String name;
        public class Dog1 {
            String a;
        }
    }

    public static void main(String[] args) {
        Parcel11 parcel11 = new Parcel11();
        Dog dog = parcel11.new Dog();
        dog.name = "xiaobai";
    }
}
