package tij.stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * StreamOfRandoms class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class StreamOfRandoms {
    static Random rand = new Random(47);

    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
                .flatMapToInt(integer -> IntStream.concat(rand.ints(0, 100).limit(integer), IntStream.of(-1)))
                .forEach(n -> System.out.format("%d ", n));
    }
}
