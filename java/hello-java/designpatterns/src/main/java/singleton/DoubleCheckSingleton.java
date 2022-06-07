package singleton;

/**
 * @author ying.zhang01
 */
public class DoubleCheckSingleton {
    private volatile static DoubleCheckSingleton doubleCheckSingleton;

    private DoubleCheckSingleton() {}

    public static DoubleCheckSingleton getInstance() {
        // 外面这层是为了不让已经实例化的单例，再次进入同步区
        if (doubleCheckSingleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                // 同步需要执行完整的校验，实例化流程,防止重复实例化
                if (doubleCheckSingleton == null) {
                    doubleCheckSingleton = new DoubleCheckSingleton();
                }
            }
        }
        return doubleCheckSingleton;
    }
}
