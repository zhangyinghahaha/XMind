package generic;

public class Tuple2<A, B> {
    public final A a1;
    public final B a2;

    public Tuple2(A a, B b) {
        this.a1 = a;
        this.a2 = b;
    }

    public String rep() {
        return a1 + ", " + a2;
    }

    @Override
    public String toString() {
        return "(" + rep() + ")";
    }
}
