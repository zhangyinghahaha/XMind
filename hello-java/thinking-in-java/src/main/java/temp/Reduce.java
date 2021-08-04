package temp;

import java.util.Random;
import java.util.stream.Stream;

/**
 * Frobnitz class
 *
 * @author zhangying
 * @date 2019/12/17
 */
class Frobnitz {
    int size;
    Frobnitz(int sz) {
        this.size = sz;
    }

    @Override
    public String toString() {
        return "Frobnitz(" + size + ")";
    }

    static Random rand = new Random(47);
    static final int BOUND = 100;
    static Frobnitz supply() {
        return new Frobnitz(rand.nextInt(BOUND));
    }
}

public class Reduce {
    public static void main(String[] args) {
        Stream.generate(Frobnitz::supply)
                .limit(10)
                .peek(System.out::println)
                .reduce((fr0, fr1) -> fr0.size < 50 ? fr0 : fr1)
                .ifPresent(System.out::println);
    }
}
