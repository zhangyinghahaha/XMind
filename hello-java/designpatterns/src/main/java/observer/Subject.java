package observer;

/**
 * Subject interface
 *
 * @author zhangying
 * @date 2019/6/27
 */
public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知所有观察者
     */
    void notifyObservers();
}
