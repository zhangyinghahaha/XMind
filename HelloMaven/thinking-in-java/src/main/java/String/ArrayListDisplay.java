package String;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayListDisplay {
    public static void main(String[] args) {
        List<Dog> dogs = Stream.generate(Dog::new).limit(10).collect(Collectors.toList());
        System.out.println(dogs.toString());
    }

    static class Dog {
        String name = "dog";

        public Dog() {}

        public Dog(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return this.name + "@" + super.toString();
        }
    }
}
