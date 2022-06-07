package basic.datatype.impl;

import basic.datatype.api.Stack;

import java.util.Iterator;

/**
 * ResizingArrayStack class
 *
 * @author ying.zhang01
 * @date 2019/11/5
 */
public class ResizingArrayStack<Item> implements Stack<Item> {
    /**
     * 栈元素存储数组
     */
    private Item[] items = (Item[]) new Object[1];
    /**
     * 栈元素数量 && 栈顶指针
     */
    private int size = 0;

    @Override
    public void push(Item item) {
        // 将元素添加到栈顶
        if (size == items.length) {
            resize(2*size);
        }
        items[size++] = item;
    }

    @Override
    public Item pop() {
        // 从栈顶删除元素
        Item item = items[--size];
        // 避免对象游离
        items[size] = null;

        if (size >0 && size == items.length/4) {
            resize(items.length/2);
        }

        return item;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }


    private void resize(int max) {
        // 将栈元素移动到一个大小为max的新数组
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = items[i];
        }
        items = temp;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    /**
     * 支持后进先出的迭代
     */
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i = size;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return items[--i];
        }
    }
}
