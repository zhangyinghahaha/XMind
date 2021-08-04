package stream;

import java.util.stream.Stream;

/**
 * FunctionMap3 class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class FunctionMap3 {
    public static void main(String[] args) {
        Stream.of("5", "7", "9")
                .mapToInt(Integer::parseInt)
                .forEach(n -> System.out.format("%d ", n));
    }
}
