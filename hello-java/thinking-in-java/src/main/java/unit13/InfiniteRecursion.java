package unit13;

import java.util.ArrayList;
import java.util.List;

/**
 * InfiniteRecursion class
 *
 * @author ying.zhang01
 * @date 2019/6/18
 */
public class InfiniteRecursion {
    @Override
    public String toString() {
        return " InfiniteRecursion address: " + super.toString() + "\n";
    }

    public static void main(String[] args) {
//        List<InfiniteRecursion> v = new ArrayList<>();
//        for(int i = 0; i < 10; i++) {
//            v.add(new InfiniteRecursion());
//        }
//        System.out.println(v);
        int x = 5;
        double y = 5.33243;
        System.out.printf("Row 1: [%d %f]\n", x, y);
        System.out.format("Row 1: [%d %f]\n", x, y);
    }
}
