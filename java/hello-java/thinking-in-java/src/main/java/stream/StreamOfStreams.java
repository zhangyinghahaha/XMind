package stream;

import java.util.stream.Stream;

/**
 * StreamOfStreams class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class StreamOfStreams {
    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }
}
