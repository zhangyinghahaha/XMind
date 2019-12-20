package tij.stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * OptionalsFromEmptyStreams class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class OptionalsFromEmptyStreams {
    public static void main(String[] args) {
        System.out.println(Stream.empty().findFirst());
        System.out.println(Stream.empty().findAny());
        //System.out.println(Stream.empty().max(String.CASE_INSENSITIVE_ORDER));
        System.out.println(Stream.<String>empty().reduce((s1, s2) -> s1 + s2));
        System.out.println(IntStream.empty().average());
    }
}
