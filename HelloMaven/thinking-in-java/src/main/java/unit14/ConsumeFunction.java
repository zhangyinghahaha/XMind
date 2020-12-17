package unit14;

import java.util.function.*;

class One {}
class Two {}

/**
 * ConsumeFunction class
 *
 * @author ying.zhang01
 * @date 2019/10/18
 */
public class ConsumeFunction {
    static Two consume(Function<One, Two> ownTwo) {
        return ownTwo.apply(new One());
    }

    public static void main(String[] args) {
        Two two = consume(one -> new Two());
    }
}
