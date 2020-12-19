package observer;

/**
 * Observer interface
 *
 * @author zhangying
 * @date 2019/6/27
 */
public interface Observer {
    /**
     * 观察者更新值
     * @param temp
     * @param humidity
     * @param pressure
     */
    void update(float temp, float humidity, float pressure);
}
