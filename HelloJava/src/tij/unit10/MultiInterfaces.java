package tij.unit10;

interface A {}

interface B {}

class X implements A, B {}

class Y implements A {
    B makeB() {
        return new B() {
        };
    }
}

/**
 * MultiInterfaces class
 *
 * @author ying.zhang01
 * @date 2019/4/19
 */
public class MultiInterfaces {
}
