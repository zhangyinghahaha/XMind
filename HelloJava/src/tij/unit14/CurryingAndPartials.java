package tij.unit14;

import java.util.function.Function;

/**
 * CurryingAndPartials class
 *
 * @author ying.zhang01
 * @date 2019/12/2
 */
public class CurryingAndPartials {
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        Function<String, Function<String, String>> sum = a -> b -> a + b;
        System.out.println(uncurried("Hi ", "Ho"));
        Function<String, String> hi = sum.apply("Hi ");
        System.out.println(hi.apply("ho"));

        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
