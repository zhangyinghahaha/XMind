package tij.unit14;

import java.util.function.Function;

/**
 * Curry3Args class
 *
 * @author ying.zhang01
 * @date 2019/12/2
 */
public class Curry3Args {
    public static void main(String[] args) {
        Function<String, Function<String, Function<String, String>>> sum = a -> b -> c -> a + b + c;
        Function<String, Function<String, String>> hi = sum.apply("Hi ");
        Function<String, String> ho = hi.apply("Ho ");
        System.out.println(ho.apply("Hup"));
    }
}