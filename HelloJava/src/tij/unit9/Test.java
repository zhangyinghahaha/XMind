package tij.unit9;

interface I1 {
    void f();
}

class I2 implements I1 {
    @Override
    public void f() {
        System.out.println("f2 I2");
    }
}

class I3 extends I2 implements I1{
    @Override
    public void f() {
        System.out.println("f2 I3");
    }
}


/**
 * Test class
 *
 * @author zhangying
 * @date 2019/4/7
 */
public class Test {

    public static void main(String[] args) {

        I2 i3 = new I3();
        i3.f();
    }
}
