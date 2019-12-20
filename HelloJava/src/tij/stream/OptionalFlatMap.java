package tij.stream;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * OptionalFlatMap class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class OptionalFlatMap {
    static String[] elements = {"12", "", "23", "45"};

    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }

    static void test(String descr, Function<String, Optional<String>> func) {
        System.out.println("----( " + descr + " )-----");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream().skip(i).findFirst().flatMap(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> Optional.of("[" + s + "]"));
    }
}
