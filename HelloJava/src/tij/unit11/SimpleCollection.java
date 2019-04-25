package tij.unit11;

import java.util.ArrayList;
import java.util.Collection;

/**
 * SimpleCollection class
 *
 * @author ying.zhang01
 * @date 2019/4/25
 */
public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> c = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++) {
            c.add(i);
        }
        for(Integer i : c) {
            System.out.print(i + ", ");
        }
    }
}
