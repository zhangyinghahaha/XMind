package tij.unit10;

/**
 * Dog class
 *
 * @author ying.zhang01
 * @date 2019/4/10
 */
public class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public class InnerDog {
        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Dog dog = new Dog("aa");
        //Dog.InnerDog innerDog = new Dog.InnerDog();
    }
}
