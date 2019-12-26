package tij.temp;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * OptionalsFromEmptyStreams class
 *
 * @author zhangying
 * @date 2019/12/17
 */
public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        Stream.<String>empty()
                .map(s -> {
                    System.out.println(s);
                    return s;
                })
                .forEach(
                System.out::println
        );
    }
}
