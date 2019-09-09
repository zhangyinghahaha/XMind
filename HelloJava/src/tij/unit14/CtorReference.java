package tij.unit14;

class Dog {
    String name;
    int age = -1;

    Dog() {name = "stray";}
    Dog(String nm) {name = nm;}
    Dog(String nm, int yrs) {name = nm; age = yrs;}
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Args {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

/**
 * CtorReference class
 *
 * @author ying.zhang01
 * @date 2019/9/9
 */
public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        Dog dn = mna.make();
        System.out.println(dn);
    }
}
