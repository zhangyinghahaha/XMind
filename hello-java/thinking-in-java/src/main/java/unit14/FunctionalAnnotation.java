package unit14;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

interface FunctionalInt {
    void goodbye(int arg);
}

//@FunctionalInterface
//interface NotFunctional {
//    String goodbye(String arg);
//    String hello(String arg);
//}

/**
 * FunctionalAnnotation class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodebye, " + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        System.out.println(f.goodbye("1"));

        FunctionalNoAnn fna = fa::goodbye;
        System.out.println(fna.goodbye("2"));

        FunctionalInt fi = a -> {
            System.out.println("void return");
        };
        fi.goodbye(3);

//        Functional fl = a -> "Goodbye, " + a;
//        FunctionalNoAnn fnal = a -> "Goodbye, " + a;
//
//        System.out.println(fl.goodbye("zhang ying"));
    }
}
