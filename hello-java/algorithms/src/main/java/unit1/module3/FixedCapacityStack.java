package unit1.module3;

import java.util.Iterator;

/**
 * FixedCapacityStackOfStrings class
 *
 * @author ying.zhang01
 * @date 2019/11/4
 */
public class FixedCapacityStack<Item> implements Iterable<Item> {
    private Item[] a;
    private int N;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    /**
     * 将元素添加到栈顶
     *
     * @param item
     */
    public void push(Item item) {
        if (N == a.length) {
            resize(2 * a.length);
        }
        a[N++] = item;
    }

    /**
     * 从栈顶删除元素
     *
     * @return
     */
    public Item pop() {
        Item item = a[--N];
        // 避免对象游离
        a[N] = null;
        if (N > 0 && N == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    /**
     * 将栈移动到一个大小为max的新数组
     *
     * @param max
     */
    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    /**
     * 支持后进先出的迭代
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = N;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
        }
    }
}