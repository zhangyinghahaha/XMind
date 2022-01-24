package search.hash;

import basic.datatype.api.Queue;
import basic.datatype.impl.LinkedQueue;
import search.api.OrderedST;
import search.basic.SequentialSearchST;
import search.bst.BST;
import utils.In;

/**
 * 基于拉链法的散列表
 * @author zhangying
 */
public class SeparateChainingHashST <Key, Value>{
    private static final int INIT_CAPACITY = 4;

    /**
     * 键值对总数
     */
    private int n;
    /**
     * 散列表的大小
     */
    private int m;
    /**
     * 散列表存储数组
     */
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(INIT_CAPACITY);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        this.st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            this.st[i] = new SequentialSearchST<>();
        }
    }

    private void resize(int chains) {
        SeparateChainingHashST<Key, Value> temp = new SeparateChainingHashST<>(chains);
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                temp.put(key, st[i].get(key));
            }
        }
        this.m = temp.m;
        this.n = temp.n;
        this.st = temp.st;
    }

    public int size() {
        return this.n;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("key为空");
        }
        return get(key) != null;
    }

    public Value get(Key key) {
        return this.st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        if (n > 8*m) {
            resize(2*m);
        }
        int hashCode = hash(key);
        if (!st[hashCode].contains(key)) {
            n++;
        }
        st[hashCode].put(key, value);
    }

    public void delete(Key key) {
        int hashCode = hash(key);
        if (st[hashCode].contains(key)) {
            n--;
            st[hashCode].delete(key);
        }

        if (size() <= m*2) {
            resize(m/2);
        }
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedQueue<>();
        for (int i = 0; i < m; i++) {
            for (Key key : st[i].keys()) {
                queue.enqueue(key);
            }
        }
        return queue;
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }

    public static void main(String[] args) {
        String input = "searchexample";
        SeparateChainingHashST<Character, Integer> st = new SeparateChainingHashST<>();
        for (int i = 0; i < input.length(); i++) {
            st.put(input.charAt(i), i);
        }

        for (Character c : st.keys()) {
            System.out.println(c + " " + st.get(c));
        }
    }
}
