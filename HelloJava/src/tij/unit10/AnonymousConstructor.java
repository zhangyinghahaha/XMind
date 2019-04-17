package tij.unit10;

/**
 * AnonymousConstructor class
 *
 * @author ying.zhang01
 * @date 2019/4/17
 */
public class AnonymousConstructor {
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }
            @Override
            public void f() {
                System.out.println("In anonyous f()");
            }
        };
    }

    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}

abstract class Base {
    public Base(int i) {
        System.out.println("Base constructor. i = " + i);
    }

    public abstract void f();
}
