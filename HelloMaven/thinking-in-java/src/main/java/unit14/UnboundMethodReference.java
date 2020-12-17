package unit14;

class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

/**
 * UnboundMethodReference class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
        //MakeString ms = X::f;
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x));
        System.out.println(x.f());
    }
}
