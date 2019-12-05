package tij.stream;

import java.util.stream.Stream;

/**
 * Bubbles class
 *
 * @author ying.zhang01
 * @date 2019/12/5
 */
public class Bubbles {
    public static void main(String[] args) {
        Stream.generate(Bubble::bubbler)
                .limit(5)
                .forEach(System.out::println);
    }
}
