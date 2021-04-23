package util;

/**
 * Test class
 *
 * @author ying.zhang01
 * @date 2019/8/3
 */
public class Test {
    public static void main(String[] args) {
        for (;;) {
            System.out.println("for");
        }
        // method(null);
//        InnerClass ic = new InnerClass();
//        ic.a = 0;
//        System.out.println(ic.a);
//
//        InnerClass2 ic2 = new InnerClass2();
//        ic2.b = 0;
//        System.out.println(ic2.b);
    }

    static class InnerClass {
        private int a;
    }

    public static void method(String param) {
        switch (param) {
            // 肯定不是进入这里
            case "sth":
                System.out.println("it's sth");
                break;
            // 也不是进入这里
            case "null":
                System.out.println("it's null");
                break;
            // 也不是进入这里
            default:
                System.out.println("default");
        }
    }
}

class InnerClass2 {
    protected int b;
}