package search.st;

import basic.datatype.api.Queue;
import basic.datatype.impl.LinkedQueue;

/**
 * 基于无序链表实现的顺序查找符号表
 * @author zhangying
 */
public class SequentialSearchST<Key, Value> implements ST<Key, Value> {

    private Node first;
    private int size;

    @Override
    public void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }
        if (value == null) {
            delete(key);
        }

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                x.value = value;
                return;
            }
        }
        first = new Node(key, value, first);
        size++;
    }

    @Override
    public Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    @Override
    public void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("argument is null");
        }

        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                if (x.next != null) {
                    x.value = x.next.value;
                    x.next = x.next.next;
                } else {
                    x = null;
                }
                size--;
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedQueue<>();
        for (Node x = first; x != null; x = x.next) {
            queue.enqueue(x.key);
        }
        return queue;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        String input = "searchexample";
        ST<Character, Integer> st = new SequentialSearchST<>();
        for (int i = 0; i < input.length(); i++) {
            st.put(input.charAt(i), i);
        }

        for (Character c : st.keys()) {
            System.out.println(c + " " + st.get(c));
        }
    }
}
