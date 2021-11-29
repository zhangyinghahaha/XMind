package search.st;

/**
 * 基于二叉查找树的符号表
 * @author zhangying
 */
public class BST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value>{

    private Node root;

    @Override
    public void put(Key key, Value value) {

    }

    /**
     * 查找key, 找到则更新它的值，否则为它创建一个新的结点
     * @param x
     * @param key
     * @param value
     * @return
     */
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value, 1);
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            x.value = value;
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else {
            x.right = put(x.right, key, value);
        }

        x.n = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Value get(Key key) {
        if (key == null || root == null) {
            return null;
        }
        return get(root, key);
    }

    /**
     * 在以x为根结点的子树中查找并返回key所对应的值, 如果找不到则返回null
     * @param x
     * @param key
     * @return
     */
    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0){
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    @Override
    public void delete(Key key) {

    }

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }

        return x.n;
    }

    @Override
    public Key min() {
        if (isEmpty()) {
            throw new IllegalArgumentException("table is empty!");
        }

        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    @Override
    public Key max() {
        if (isEmpty()) {
            throw new IllegalArgumentException("table is empty!");
        }
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) {
            return x;
        }
        return max(x);
    }

    @Override
    public Key floor(Key key) {
        return null;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }

        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return size(x.left);
        } else if (cmp < 0) {
            return rank(x.left, key);
        } else {
            return 1 + size(x.left) + rank(x.right, key);
        }
    }

    @Override
    public Key select(int k) {
        if (k < 0 || k >= size()) {
            throw new IllegalArgumentException("called select() with invalid argument: " + k);
        }
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k-t-1);
        } else {
            return x;
        }
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }
}