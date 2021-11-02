package sort.pq;

/**
 * 基于数组实现的优先队列
 *
 * @author zhangying
 */
public class ArrayMaxPQ<Item extends Comparable<Item>> implements MaxPQ<Item>{
    /**
     * 元素存储数组
     */
    private Item[] items = (Item[]) new Object[1];

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
        return null;
    }

    @Override
    public Item delMax() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    private void resize(int max) {
        // 将栈元素移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }
}
