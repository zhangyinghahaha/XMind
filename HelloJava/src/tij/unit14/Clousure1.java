package tij.unit14;

import java.util.function.*;

/**
 * Clousure1 class
 *
 * @author ying.zhang01
 * @date 2019/10/22
 */
public class Clousure1 {
    IntSupplier makeFun(int x) {
        int i =0;
        //x = x + 1;
        //i++;
        return () -> {return x + i;};
    }
}
