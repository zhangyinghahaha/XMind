package basic.datatype.api;

/**
 * 下压栈(后进先出, LIFO)
 *
 * @author zhangying
 */
public interface Stack<E> extends Iterable<E> {
    /**
     * 添加一个元素
     *
     * @param e 元素
     */
    void push(E e);

    /**
     * 删除最近添加的元素
     *
     * @return 被删除的元素
     */
    E pop();

    /**
     * 栈是否为空
     *
     * @return 栈为空时返回true
     */
    boolean isEmpty();

    /**
     * 栈中的元素数量
     *
     * @return 元素数量
     */
    int size();
}
