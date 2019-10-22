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
        Integer i=0;
        i++;
        //int ifinal = i;
        return () -> x + i;
    }
}
