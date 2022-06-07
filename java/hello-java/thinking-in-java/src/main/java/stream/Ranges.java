package stream;

import static java.util.stream.IntStream.range;

/**
 * Ranges class
 *
 * @author ying.zhang01
 * @date 2019/12/5
 */
public class Ranges {
    public static void main(String[] args) {
        int result = 0;
        for(int i = 10; i < 20; i++) {
            result += i;
        }
        System.out.println(result);
        System.out.println(range(10, 20).sum());
    }
}
