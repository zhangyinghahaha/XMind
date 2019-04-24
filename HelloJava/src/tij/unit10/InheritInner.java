package tij.unit10;

class WithInner {
    class Inner {
        Inner(String i) {}
    }
}


/**
 * InheritInner class
 *
 * @author ying.zhang01
 * @date 2019/4/24
 */
public class InheritInner extends WithInner.Inner {
    InheritInner(WithInner wi) {
        wi.super("");
    }

    public static void main(String[] args) {
        WithInner withInner = new WithInner();
        WithInner.Inner inner = withInner.new Inner("");
    }
}
