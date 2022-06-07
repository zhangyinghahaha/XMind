package unit11;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * SetOfInteger class
 *
 * @author ying.zhang01
 * @date 2019/4/29
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for(int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        System.out.println(intset);
    }
}
