package stream;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * OptionalFilter class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class OptionalFilter {
    static String[] elements = {"Foo", "", "Bar", "Baz", "Bingo"};
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }
    static void test(String descr, Predicate<String> pred) {
        System.out.println(" ---( " + descr + " )---");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(
                    testStream().skip(i).findFirst().filter(pred)
            );
        }
    }

    public static void main(String[] args) {
        test("true", str -> true);
        test("false", str -> false);
        test("str != \"\"", str -> str != "");
    }
}
