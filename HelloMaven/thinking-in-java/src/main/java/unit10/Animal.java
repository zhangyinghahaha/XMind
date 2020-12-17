package unit10;

/**
 * Dog class
 *
 * @author ying.zhang01
 * @date 2019/4/10
 */
public class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public class Dog {
        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

    }
}
