package tij.stream;

import java.util.Optional;

/**
 * StreamOfOptionals class
 *
 * @author ying.zhang01
 * @date 2019/12/12
 */
public class StreamOfOptionals {
    public static void main(String[] args) {
        Signal.stream()
                .limit(10)
                .forEach(System.out::println);
        System.out.println(" ---");
        Signal.stream()
                .limit(10)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);
    }
}
