package stream;

import java.util.Random;

/**
 * Randoms class
 *
 * @author ying.zhang01
 * @date 2019/12/2
 */
public class Randoms {
    public static void main(String[] args) {
        new Random(47).ints(5, 20).distinct().limit(7).sorted().forEach(System.out::println);
    }
}
