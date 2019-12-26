package tij.temp;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * LastElement class
 *
 * @author zhangying
 * @date 2019/12/18
 */
public class LastElement {
    public static void main(String[] args) {
        OptionalInt last = IntStream.range(10, 20)
                .reduce((n1, n2) -> n2);
        System.out.println(last.orElse(-1));

        Optional<String> lastobj = Stream.of("one", "two", "three")
                .reduce((n1, n2) -> n2);
        System.out.println(lastobj.orElse("Nothing there!"));
    }
}
