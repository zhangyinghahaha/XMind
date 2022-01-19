package search.basic;

import basic.datatype.api.Queue;
import basic.datatype.impl.LinkedQueue;
import search.api.OrderedST;

/**
 * 基于一对平行数组的二分查找符号表
 * @author zhangying
 */
public class BinarySearchSt<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private Key[] keys;
    private Value[] values;
    private int size;

    public BinarySearchSt(int size) {
        keys = (Key[]) new Comparable[size];
        values =(Value[]) new Object[size];
    }

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }
        if (value == null) {
            delete(key);
        }

        int i = rank(key);
        if (i < size && keys[i].equals(key)) {
            values[i] = value;
            return;
        }

        for (int j = size; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }

        if (isEmpty()) {
            return null;
        }

        int i = rank(key);
        if (i < size && keys[i].equals(key)) {
            return values[i];
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }

        int rank = rank(key);
        if (rank < size && keys[rank].equals(key)) {
            for (int i = rank + 1; i < size; i++) {
                keys[i - 1] = keys[i];
                values[i - 1] = values[i];
            }
            size--;
            keys[size] = null;
            values[size] = null;
        }
    }

    @Override
    public boolean contains(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }
        return get(key) != null;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Key min() {
        if (isEmpty()) {
            throw new IllegalArgumentException("table is empty!");
        }
        return keys[0];
    }

    @Override
    public Key max() {
        if (isEmpty()) {
            throw new IllegalArgumentException("table is empty!");
        }
        return keys[size - 1];
    }

    @Override
    public Key floor(Key key) {
        if (isEmpty()) {
            throw new IllegalArgumentException("table is empty!");
        }

        int rank = rank(key);
        if (rank < size && keys[rank].equals(key)) {
            return keys[rank];
        }
        return keys[rank - 1];
    }

    @Override
    public Key ceiling(Key key) {
        if (isEmpty()) {
            throw new IllegalArgumentException("table is empty!");
        }

        return keys[rank(key)];
    }

    @Override
    public int rank(Key key) {
        if (key == null){
            throw new IllegalArgumentException("argument to contains() is null");
        }

        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp == 0) {
                return mid;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    @Override
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return keys[k];
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new LinkedQueue<>();
        if (lo.compareTo(hi) > 0) {
            return queue;
        }
        for (int i = rank(lo); i < rank(hi); i++) {
            queue.enqueue(keys[i]);
        }
        if (contains(hi)) {
            queue.enqueue(keys[rank(hi)]);
        }
        return queue;
    }

    public static void main(String[] args) {
        String input = "searchexample";
        OrderedST<Character, Integer> st = new BinarySearchSt<>(20);
        for (int i = 0; i < input.length(); i++) {
            st.put(input.charAt(i), i);
        }

        for (Character c : st.keys()) {
            System.out.println(c + " " + st.get(c));
        }
    }

}
