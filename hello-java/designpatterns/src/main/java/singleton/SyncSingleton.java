package singleton;

/**
 * @author ying.zhang01
 */
public class SyncSingleton {
    private static SyncSingleton uniqueInstance;

    private SyncSingleton() {}

    /**
     * 很有效，但有点浪费性能
     * @return
     */
    public static synchronized SyncSingleton getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new SyncSingleton();
        }
        return uniqueInstance;
    }
}
