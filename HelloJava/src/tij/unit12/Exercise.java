package tij.unit12;

class A extends Exception {
    public A () {}

    public A(String msg) {
        super(msg);
    }
}

class B extends Exception {
    public B () {}

    public B(String msg) {
        super(msg);
    }
}

class C extends Exception {
    public C () {}

    public C(String msg) {
        super(msg);
    }
}


/**
 * Exercise class
 *
 * @author ying.zhang01
 * @date 2019/5/20
 */
public class Exercise {
    public static void f() throws A, B, C {
        throw new A();
        //throw new B();
        //throw new C();
    }

    public static void main(String[] args) {
        try {
            Exercise.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
