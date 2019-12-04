package tij.unit14;

import java.util.function.*;

/**
 * FinctionComposition class
 *
 * @author ying.zhang01
 * @date 2019/10/23
 */
public class FinctionComposition {
    static Function<String, String>
            f1 = s -> { System.out.println(s);return s.replace('A', '_'); },
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(),
            f4 = f1.compose(f2).andThen(f3);

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    }
}