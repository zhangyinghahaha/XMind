package sort.pq;

/**
 * 关联索引的优先队列
 *
 * @author zhangying
 */
public interface IndexMinPQ<Item extends Comparable<Item>>{
    /**
     * 插入一个元素，将它和索引k关联
     *
     * @param k
     * @param item
     */
    void insert(int k, Item item);

    /**
     * 将索引为k的元素设为item
     * @param k
     * @param item
     */
    void change(int k, Item item);

    /**
     * 是否存在索引为k的元素
     * @param k
     * @return
     */
    boolean contains(int k);

    /**
     * 删除索引k及其相关联的元素
     * @param k
     */
    void delete(int k);

    /**
     * 返回最小元素
     * @return
     */
    Item min();

    /**
     * 返回最小元素的索引
     * @return
     */
    int minIndex();

    /**
     * 删除最小元素并返回它的索引
     * @return
     */
    int delMin();

    /**
     * 优先队列是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 优先队列中的元素数量
     * @return
     */
    int size();
}
