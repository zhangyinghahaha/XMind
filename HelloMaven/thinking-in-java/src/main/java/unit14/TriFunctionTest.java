package unit14;

import java.util.function.*;

interface TriFunction<T, U, V, R> {
    R apply(T t, U u, V v);
}

/**
 * TriFunctionTest class
 *
 * @author ying.zhang01
 * @date 2019/10/18
 */
public class TriFunctionTest {
    static int f(int i, long l, double d) {return 99;}

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        System.out.println(tf.apply(1,2L,3d));

        tf = (i, l, d) -> 12;
        System.out.println(tf.apply(1,2L,3D));
    }
}
