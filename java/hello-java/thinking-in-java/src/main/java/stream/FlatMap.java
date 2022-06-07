package stream;

import java.util.stream.Stream;

/**
 * FlatMap class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class FlatMap {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .flatMap(i -> Stream.of("Gonzo", "Fozzie", "Beaker"))
                .forEach(System.out::println);
    }
}
