package search.hash;

/**
 * 基于线性探测的符号表
 *
 * @author zhangying
 */
public class LinearProbingHashSt<Key, Value> {
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * 符号表中键值对的数量
     */
    private int n;
    /**
     * 线性探测表的大小
     */
    private int m;
    /**
     * 键
     */
    private Key[] keys;
    /**
     * 值
     */
    private Value[] values;

    public LinearProbingHashSt() {
        this(DEFAULT_CAPACITY);
    }

    public LinearProbingHashSt(int capacity) {
        keys = (Key[]) new Object[capacity];
        values = (Value[]) new Object[capacity];
        this.m = capacity;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public void put(Key key, Value value) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1)%m) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1)%m) {
            if (keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }

        // 查找并删除key
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }
        keys[i] = null;
        values[i] = null;

        // 将簇中被删除键的右侧的所有键重新插入散列表
        i = (i + 1) % m;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valueToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            n--;
            put(keyToRedo, valueToRedo);
            i = (i + 1) % m;
        }

        // 将散列表键值对数量减一，并检查是否需要调整线性探测表大小
        n--;
        if (n > 0 && n <= m/8) {
            resize(m/2);
        }
    }

    private void resize(int capacity) {
        LinearProbingHashSt<Key, Value> tmp = new LinearProbingHashSt<>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                tmp.put(keys[i], values[i]);
            }
        }

        keys = tmp.keys;
        values = tmp.values;
        this.m = tmp.m;
    }
}
