package basic.datatype.api;

/**
 * 背包
 *
 * @author zhangying
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * 添加一个元素
     *
     * @param e 元素
     */
    void add(E e);

    /**
     * 背包是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 背包中的元素数量
     *
     * @return 元素数量
     */
    int size();
}
