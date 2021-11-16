package search.st;

/**
 * 有序符号表
 *
 * @author zhangying
 */
public interface OrderedST<Key extends Comparable<Key>, Value> {
    /**
     * 将键值对存入表中，若值为空则将键从表中删除
     * @param key
     * @param value
     */
    void put(Key key, Value value);

    /**
     * 获取键key的值，若键不存在则返回空
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * 从表中删除键及其对应的值
     * @param key
     */
    void delete(Key key);

    /**
     * 键key是否存在于表中
     * @param key
     * @return
     */
    boolean contains(Key key);

    /**
     * 表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 表中键值对的数量
     * @return
     */
    int size();

    /**
     * 最小的键
     * @return
     */
    Key min();

    /**
     * 最大的键
     * @return
     */
    Key max();

    /**
     * 小于等于key最大的键
     * @param key
     * @return
     */
    Key floor(Key key);

    /**
     * 大于等于key最小的键
     * @param key
     * @return
     */
    Key ceiling(Key key);

    /**
     * 返回键在表中的排名值
     * @param key
     * @return
     */
    int rank(Key key);

    /**
     * 排名为k的键
     * @param k
     * @return
     */
    int select(int k);

    /**
     * 删除表中最小的键
     */
    default void deleteMin() {
        delete(min());
    }

    /**
     * 删除表中最大的键
     */
    default void deleteMax() {
        delete(max());
    }

    /**
     * [lo..hi]之间键的数量
     * @param lo
     * @param hi
     * @return
     */
    default int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    /**
     * [lo..hi]之间所有的键
     * @param lo
     * @param hi
     * @return
     */
    Iterable<Key> keys(Key lo, Key hi);

    /**
     * 表中所有键的集合
     * @return
     */
    default Iterable<Key> keys() {
        return keys(min(), max());
    }
}
