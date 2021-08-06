package unit14;

import java.util.function.Supplier;
import java.util.stream.*;

/**
 * DynamicSupplier class
 *
 * @author ying.zhang01
 * @date 2019/9/6
 */
class CountedInteger {
    private static long counter;
    private final long id = counter++;

    @Override
    public String toString() {
        return Long.toString(id);
    }
}

public class DynamicSupplier<T> implements Supplier<T> {
    private Class<T> type;
    public DynamicSupplier(Class<T> type) {
        this.type = type;
    }
    @Override
    public T get() {
        try {
            return type.newInstance();
        } catch(InstantiationException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Stream.generate(
                new DynamicSupplier<>(CountedInteger.class))
                .skip(10)
                .limit(5)
                .forEach(System.out::println);
    }
}
