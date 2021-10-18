package sort.pq;

/**
 * 优先队列
 *
 * @author zhangying
 */
public interface MaxPQ<Key extends Comparable<Key>> {
    /**
     * 向优先队列中插入一个元素
     *
     * @param v 元素
     */
    void insert(Key v);

    /**
     * 返回最大元素
     *
     * @return 最大元素
     */
    Key max();

    /**
     * 删除并返回最大元素
     *
     * @return 最大元素
     */
    Key delMax();

    /**
     * 返回队列是否为空
     *
     * @return 如果为空返回true
     */
    boolean isEmpty();

    /**
     * 返回优先队列中的元素个数
     *
     * @return 数量
     */
    int size();
}
