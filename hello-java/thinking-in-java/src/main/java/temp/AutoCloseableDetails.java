package temp;

import java.util.Random;

class Reporter implements AutoCloseable {
    String name = getClass().getSimpleName();

    Reporter() {
        System.out.println("Creating " + name);
    }

    @Override
    public void close() {
        System.out.println("Closing " + name);
    }
}

class First extends Reporter {}
class Second extends Reporter {}

/**
 * AutoCloseableDetails class
 *
 * @author ying.zhang01
 * @date 2020/1/8
 */
public class AutoCloseableDetails {
    public static void main(String[] args) {
        try (
                First f = new First();
                Second s = new Second();
                //String a = "aaa";
                ) {
            System.out.println("Try 内部");
        }
    }
}
