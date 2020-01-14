package tij.generic;

/**
 * Holder1 class
 *
 * @author ying.zhang01
 * @date 2020/1/14
 */
public class Holder1 {
    private Automobile a;
    public Holder1(Automobile a) {
        this.a = a;
    }
    Automobile get() {
        return a;
    }
}

class Automobile {}
