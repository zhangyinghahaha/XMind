package stream;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * OptionalMap class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class OptionalMap {
    static String[] elements = {"12", "", "23", "45"};
    static Stream<String> testStream() {
        return Arrays.stream(elements);
    }
    static void test(String descr, Function<String, String> func) {
        System.out.println(" ---( " + descr + " )--- ");
        for (int i = 0; i <= elements.length; i++) {
            System.out.println(testStream().skip(i).findFirst().map(func));
        }
    }

    public static void main(String[] args) {
        test("Add brackets", s -> "[" + s + "]");
        test("Increment", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch (NumberFormatException e) {
                return s;
            }
        });
        test("Replace", s -> s.replace("2", "9"));
    }
}
