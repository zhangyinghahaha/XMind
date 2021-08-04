package singleton;

/**
 * Singleton class
 *
 * @author ying.zhang01
 * @date 2020/1/16
 */
public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {}

    public static Singleton getInstance() {
        if(uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}
