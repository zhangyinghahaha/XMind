package search.st;


/**
 * 基于红黑树的符号表
 * @author zhangying
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    @Override
    public void put(Key key, Value value) {

    }

    @Override
    public Value get(Key key) {
        return null;
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
        return 0;
    }

    private int size(Node x) {
        if (x == null) {
            return 0;
        }
        return x.nums;
    }

    @Override
    public Key min() {
        return null;
    }

    @Override
    public Key max() {
        return null;
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
        return 0;
    }

    @Override
    public Key select(int k) {
        return null;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    private class Node {
        // 键
        private Key key;
        // 值
        private Value value;
        // 左右子树
        Node left, right;
        // 当前树中结点的总数
        int nums;
        // 由其父节点指向它的链接的颜色
        boolean color;

        public Node(Key key, Value value, int nums, boolean color) {
            this.key = key;
            this.value = value;
            this.nums = nums;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    /**
     * 左旋转
     * @param h
     * @return
     */
    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.nums = h.nums;
        h.nums = 1 + size(x.left) + size(x.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.nums = h.nums;
        h.nums = 1 + size(h.left) + size(x.right);
        return x;
    }

    private void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
}
