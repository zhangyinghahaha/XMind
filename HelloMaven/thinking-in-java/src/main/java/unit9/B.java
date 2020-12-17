package unit9;

/**
 * B interface
 *
 * @author ying.zhang01
 * @date 2020/1/7
 */
public interface B {
    public default void a() {
        System.out.println("这是B");
    }
}
