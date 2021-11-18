package search.st;

/**
 * 顺序查找的无序符号表
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
            if (x.equals(key)) {
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
            if (x.equals(key)) {
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
            if (x.equals(key)) {
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
        return null;
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
}
