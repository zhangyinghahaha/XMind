package search.hash;

/**
 * 基于线性探测的符号表
 *
 * @author zhangying
 */
public class LinearProbingHashSt<Key, Value> {
    private int n;
    private int m = 16;
    private Key[] keys;
    private Value[] values;

    public LinearProbingHashSt() {
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
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
}
