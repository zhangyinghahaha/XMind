package sort.pq;

import sort.api.MaxPQ;

/**
 * 基于数组实现的优先队列
 *
 * @author zhangying
 */
public class ArrayMaxPQ<Item extends Comparable<Item>> implements MaxPQ<Item> {
    /**
     * 元素存储数组
     */
    private Item[] items = (Item[]) new Comparable[2];

    // 优先队列元素 && 栈顶指针
    private int size = 0;

    @Override
    public void insert(Item v) {
        if (size == items.length) {
            resize(2*size);
        }
        items[size++] = v;
    }

    @Override
    public Item max() {
        return items[maxIndex()];
    }

    @Override
    public Item delMax() {
        if (isEmpty()) {
            return null;
        }

        int maxIndex = maxIndex();
        Item max = items[maxIndex];
        items[maxIndex] = items[--size];
        items[size] = null;
        if (size > 0 && size <= items.length/4) {
            resize(items.length/2);
        }
        return max;
    }

    @Override
    public boolean isEmpty() {
        return size <= 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int max) {
        // System.out.println("Resize: " + items.length + " --> " + max);
        // 将栈元素移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Comparable[max];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    private boolean less(Item a, Item b) {
        return a.compareTo(b) < 0;
    }

    private int maxIndex() {
        int max = 0;
        for (int i = 0; i < size; i++) {
            if (less(items[max], items[i])) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 6, 2, 4, 3};

        ArrayMaxPQ<Integer> maxPQ = new ArrayMaxPQ<>();
        for (int i = 0; i < input.length; i++) {
            maxPQ.insert(input[i]);
        }
        while (!maxPQ.isEmpty()) {
            int max = maxPQ.delMax();
            System.out.println(max);
        }
    }
}
