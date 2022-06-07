package sort.pq;

import sort.api.MaxPQ;

/**
 * 基于二叉堆实现的优先队列
 *
 * @author zhangying
 */
public class HeapMaxPQ<Item extends Comparable<Item>> implements MaxPQ<Item> {
    /**
     * 元素存储数组
     */
    private Item[] pq = (Item[]) new Comparable[2];
    /**
     * 元素数量 && 队尾指针
     */
    private int size = 1;

    @Override
    public void insert(Item v) {
        if (size == pq.length) {
            resize(2*size);
        }

        pq[size] = v;
        this.swim(size++);
    }

    @Override
    public Item max() {
        return pq[1];
    }

    @Override
    public Item delMax() {
        Item max = pq[1];
        pq[1] = pq[--size];
        pq[size] = null;
        this.sink(1);
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size - 1 <= 0;
    }

    @Override
    public int size() {
        return size - 1;
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Item t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }

    private void resize(int max) {
        // System.out.println("Resize: " + items.length + " --> " + max);
        // 将栈元素移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Comparable[max];
        for (int i = 0; i < size; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * 由下至上的堆有序化
     *
     * @param k 破环堆有序状态的节点索引
     */
    private void swim(int k) {
        while (k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }

    /**
     * 有上至下的堆有序化
     *
     * @param k 破环堆有序状态的节点索引
     */
    private void sink(int k) {
        while (2*k <= this.size()) {
            int maxChild = 2*k;
            if (2*k < this.size() && less(2*k, 2*k+1)) {
                maxChild = 2*k + 1;
            }

            if (!less(k, maxChild)) {
                break;
            }
            exch(k, maxChild);
            k = maxChild;
        }
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 6, 2, 4, 3};

        HeapMaxPQ<Integer> maxPQ = new HeapMaxPQ<>();
        for (int i = 0; i < input.length; i++) {
            maxPQ.insert(input[i]);
        }
        while (!maxPQ.isEmpty()) {
            int max = maxPQ.delMax();
            System.out.println(max);
        }
    }
}
