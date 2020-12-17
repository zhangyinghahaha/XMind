package unit14;

import java.util.function.*;

/**
 * SharedStorage class
 *
 * @author ying.zhang01
 * @date 2019/10/22
 */
public class SharedStorage {
    public static void main(String[] args) {
        Clousure1 c1 = new Clousure1();
        IntSupplier f1 = c1.makeFun(0);
        IntSupplier f2 = c1.makeFun(0);
        IntSupplier f3 = c1.makeFun(0);
        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());

    }
}
