package unit14;

import java.util.*;
import java.util.function.*;

/**
 * Closure8 class
 *
 * @author ying.zhang01
 * @date 2019/10/23
 */
public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        List<Integer> ai = new ArrayList<>();
        ai.add(1);
        return () -> ai;
    }
}
