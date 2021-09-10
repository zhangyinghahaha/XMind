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
     * 栈元素
     */
    private Item[] items = (Item[]) new Object[1];
    /**
     * 元素数量
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
        return null;
    }
}
