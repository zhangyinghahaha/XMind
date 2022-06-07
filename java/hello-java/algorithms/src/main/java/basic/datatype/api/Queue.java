package basic.datatype.api;

/**
 * 先进先出(FIFO)队列
 * @author zhangying
 */
public interface Queue<E> extends Iterable<E> {
    /**
     * 添加一个元素
     *
     * @param e 元素
     */
    void enqueue(E e);

    /**
     * 删除最早添加的一个元素
     *
     * @return 被删除的元素
     */
    E dequeue();

    /**
     * 对象是否为空
     *
     * @return true队列为空时返回
     */
    boolean isEmpty();

    /**
     * 队列中的元素数量
     *
     * @return 元素数量
     */
    int size();
}
