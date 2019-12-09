package tij.stream;

import java.util.stream.Stream;

/**
 * Fibonacci class
 *
 * @author ying.zhang01
 * @date 2019/12/5
 */
public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .limit(10)
                .forEach(System.out::println);
    }
}