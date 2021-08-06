package unit11;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Statistics class
 *
 * @author ying.zhang01
 * @date 2019/4/29
 */
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> m = new HashMap<>(16);
        for(int i = 0; i < 10000; i++) {
            int r = rand.nextInt(20);
            Integer freq = m.get(r);
            m.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(m);
    }
}
