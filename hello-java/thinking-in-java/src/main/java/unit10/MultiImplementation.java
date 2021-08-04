package unit10;

class D {}

abstract class E {}

class Z extends D {
    E makeE() {
        return new E() {
        };
    }
}

/**
 * MultiImplementation class
 *
 * @author ying.zhang01
 * @date 2019/4/19
 */
public class MultiImplementation {
    static void takesD(D d) {}
    static void takesE(E e) {}

    public static void main(String[] args) {
        Z z = new Z();
        takesD(z);
        takesE(z.makeE());
    }
}
