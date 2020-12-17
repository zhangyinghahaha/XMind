package stream;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * OptionalBasics class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class OptionalBasics {
    static void test(Optional<String> optString) {
        if(optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }
}
