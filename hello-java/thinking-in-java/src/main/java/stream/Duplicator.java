package stream;

import java.util.stream.Stream;

/**
 * Duplicator class
 *
 * @author ying.zhang01
 * @date 2019/12/5
 */
public class Duplicator {
    public static void main(String[] args) {
        Stream.generate(() -> "duplicate")
                .limit(3)
                .forEach(System.out::println);
    }
}
