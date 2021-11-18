package search.st;

/**
 * 符号表
 *
 * @author zhangying
 */
public interface ST<Key, Value> {
    /**
     * 将键值对存入表中，若值为空则将键从表中删除
     * @param key
     * @param value
     */
    void put(Key key, Value value);

    /**
     * 获取键对应的值，若键不存在则返回空
     * @param key
     * @return
     */
    Value get(Key key);

    /**
     * 从表中删除键
     * @param key
     */
    void delete(Key key);

    /**
     * 键是否在表中
     * @param key
     * @return
     */
    default boolean contains(Key key) {
        return get(key) != null;
    }

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
     * 表中所有键的集合
     * @return
     */
    Iterable<Key> keys();
}
