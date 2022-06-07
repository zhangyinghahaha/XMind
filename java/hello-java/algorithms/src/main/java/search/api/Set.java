package search.api;

/**
 * 集合
 * @author zhangying
 */
public interface Set<Key> {
    /**
     * 将键key加入集合
     * @param key
     */
    void add(Key key);

    /**
     * 从集合中删除键key
     * @param key
     */
    void delete(Key key);

    /**
     * key是否在集合中
     * @param key
     * @return
     */
    boolean contains(Key key);

    /**
     * 集合是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 集合中键的数量
     * @return
     */
    int size();
}
