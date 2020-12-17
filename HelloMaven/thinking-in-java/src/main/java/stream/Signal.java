package stream;

import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Signal class
 *
 * @author ying.zhang01
 * @date 2019/12/12
 */
public class Signal {
    private final String msg;
    public Signal(String msg) {
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    @Override
    public String toString() {
        return "Signal(" + msg + ")";
    }
    static Random rand = new Random(47);
    public static Signal morse() {
        switch (rand.nextInt(4)) {
            case 1: return new Signal("dot");
            case 2: return new Signal("dash");
            default: return null;
        }
    }
    public static Stream<Optional<Signal>> stream() {
        return Stream.generate(Signal::morse)
                .map(signal -> Optional.ofNullable(signal));
    }
}
