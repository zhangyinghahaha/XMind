package stream;

import java.util.*;
import java.util.stream.Stream;

/**
 * StreamOf class
 *
 * @author ying.zhang01
 * @date 2019/12/2
 */
public class StreamOf {
    public static void main(String[] args) {
        Stream.of("It's", "a ", "wonderful ", "day ", "for ", "pie!").forEach(System.out::print);
        System.out.println();
        Stream.of(3.1, 3.2, 3.2).forEach(System.out::print);

        Set<String> w = new HashSet<>(Arrays.asList("It's a wonderful day for pie!".split(" ")));
        w.stream().map(x -> x + " ").forEach(System.out::print);
        System.out.println();

        Map<String, Double> m = new HashMap<>();
        m.put("pi", 3.14);
        m.put("e", 2.71);
        m.put("phi", 1.61);
        m.entrySet().stream().map(e -> e.getKey() + ": " + e.getValue()).forEach(System.out::println);

        TestZ a = new TestZ();
        System.out.println(a.a);
    }
}

class TestZ {
    public String a;
}
