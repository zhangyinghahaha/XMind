package tij.stream;

import static tij.stream.RandInts.rands;

/**
 * ForEach class
 *
 * @author ying.zhang01
 * @date 2019/12/12
 */
public class ForEach {
    static final int SZ = 14;

    public static void main(String[] args) {
        rands().limit(SZ)
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        rands().limit(SZ)
                .parallel()
                .forEach(n -> System.out.format("%d ", n));
        System.out.println();
        rands().limit(SZ)
                .parallel()
                .forEachOrdered(n -> System.out.format("%d ", n));
    }
}
