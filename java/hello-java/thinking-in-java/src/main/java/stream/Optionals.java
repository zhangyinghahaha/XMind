package stream;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

/**
 * Optionals class
 *
 * @author ying.zhang01
 * @date 2019/12/11
 */
public class Optionals {
    static void basics(Optional<String> optString) {
        if(optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }
    static void ifPresent(Optional<String> optString) {
        // optString.ifPresent(System.out::println);
        optString.ifPresent(element -> {
            System.out.println("hello" + element);
        });
    }

    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("Nada"));
    }

    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(
                    () -> new Exception("Supplied")
            ));
        } catch (Exception e) {
            System.out.println("Caught " + e);
        }
    }
    static void test(String testName, Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        cos.accept(Stream.of("Epithets").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
//        test("basics", Optionals::basics);
//        test("ifPresent", Optionals::ifPresent);
//        test("orElse", Optionals::orElseThrow);
        ifPresent(Optional.empty());
        ifPresent(Optional.ofNullable(null));
        Optional.ofNullable(new Optionals()).ifPresent(element -> {
            System.out.println(element);
        });
    }
}
