package tij.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Generator class
 *
 * @author ying.zhang01
 * @date 2019/12/5
 */
public class Generator implements Supplier<String> {
    Random rand = new Random(47);
    char[] letters = "ABCDEFG".toCharArray();

    @Override
    public String get() {
        return "" + letters[rand.nextInt(letters.length)];
    }

    public static void main(String[] args) {
        Stream.generate(new Generator()).forEach(System.out::println);
        // System.out.println(word);
    }
}
