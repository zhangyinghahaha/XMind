package unit7;

import static com.ying.util.Print.*;

class WithFinals {
    public final void f() {
        print("WithFinals.f()");
    }

    private void g() {
        print("WithFinals.g()");
    }
}

class OverridingPrivate extends WithFinals {
    public void f() {
        print("OverridingPrivate.f()");
    }

    private void g() {
        print("OverridingPrivate.g()");
    }
}

public class FinalOverridingIllusion {

    public static void main(String[] args) {
        OverridingPrivate op2 = new OverridingPrivate();
        op2.f();
        op2.g();
    }
}
