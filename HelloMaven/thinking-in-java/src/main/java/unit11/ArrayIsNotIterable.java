package unit11;

import java.util.Arrays;

/**
 * ArrayIsNotIterable class
 *
 * @author ying.zhang01
 * @date 2019/5/5
 */
public class ArrayIsNotIterable {
    static <T> void test(Iterable<T> ib) {
        for(T t : ib) {
            System.out.println(t + " ");
        }
    }

    public static void main(String[] args) {
        test(Arrays.asList(1,  2, 3));
        String[] strings = {"A", "B", "C"};
        test(Arrays.asList(strings));
    }
}
