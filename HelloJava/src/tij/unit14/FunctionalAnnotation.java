package tij.unit14;

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

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
        FunctionalNoAnn fna = fa::goodbye;
        Functional fl = a -> "Goodbye, " + a;
        FunctionalNoAnn fnal = a -> "Goodbye, " + a;

        System.out.println(fl.goodbye("zhang ying"));
    }
}
