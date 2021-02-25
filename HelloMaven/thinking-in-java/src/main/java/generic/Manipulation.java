package generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HasF {
    public void f() {
        System.out.println("HasF.f()");
    }
}

class Manipulator<T extends HasF> {
    private T obj;
    Manipulator(T x) {
        obj = x;
    }

    public void manipulate() {
        obj.f();
        System.out.println(obj.getClass().getSimpleName());
    }
}

public class Manipulation<T> {
    public static void main(String[] args) {
        HasF hf = new HasF();
        Manipulator<HasF> manipulator = new Manipulator<>(hf);
        manipulator.manipulate();
        System.out.println(Arrays.toString(manipulator.getClass().getTypeParameters()));

        List al = new ArrayList();
        al.add("111");
        al.add(1);
        System.out.println(al);
    }
}
