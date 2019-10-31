package tij.unit14;

import java.util.function.*;

/**
 * AnonymousClosure class
 *
 * @author ying.zhang01
 * @date 2019/10/23
 */
public class AnonymousClosure {
    IntSupplier makeFun(int x) {
        int i = 0;
        //i++;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
                return x + i;
            }
        };
    }
}
