package tij.unit9;

import java.util.Random;

/**
 * RandomDoubles class
 *
 * @author zhangying
 * @date 2019/4/7
 */
public class RandomDoubles {
    private static Random rand = new Random(47);

    public double next() {
        return rand.nextDouble();
    }
}
