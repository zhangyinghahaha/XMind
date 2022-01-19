package search.hash;

import search.api.OrderedST;
import search.basic.SequentialSearchST;
import search.bst.BST;
import utils.In;

/**
 * 基于拉链法的散列表
 * @author zhangying
 */
public class SeparateChainingHashST <Key, Value>{
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
        this(16);
    }

    public SeparateChainingHashST(int m) {
        this.m = m;
        this.st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            this.st[i] = new SequentialSearchST<>();
        }
    }

    public Value get(Key key) {
        return this.st[hash(key)].get(key);
    }

    public void put(Key key, Value value) {
        st[hash(key)].put(key, value);
    }

    public Iterable<Key> keys() {
        return null;
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
