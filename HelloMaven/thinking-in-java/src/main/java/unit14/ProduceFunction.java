package unit14;

import java.util.function.*;

interface FuncSS extends Function<String, String> {}

/**
 * ProduceFunction class
 *
 * @author ying.zhang01
 * @date 2019/10/18
 */
public class ProduceFunction {
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("HELLO"));
    }
}
