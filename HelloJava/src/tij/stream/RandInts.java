package tij.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * RandInts class
 *
 * @author ying.zhang01
 * @date 2019/12/12
 */
public class RandInts {
    private static int[] rints = new Random(47).ints(0, 100).limit(100).toArray();
    public static IntStream rands() {
        return Arrays.stream(rints);
    }
}
