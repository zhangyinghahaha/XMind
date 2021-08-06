package enums;

public interface Animal {
    String NAME = "Animal";

    default void run() {
        System.out.println(NAME);
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.run();
    }
}

class Dog implements Animal {
    @Override
    public void run() {
        System.out.println("Dog");
    }
}
