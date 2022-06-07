package basic.datatype.impl;

import basic.datatype.api.Stack;

import java.util.Iterator;

/**
 * @author zhangying
 */
public class LinkedStack<Item> implements Stack<Item> {

    /**
     * 栈顶指针
     */
    private Node<Item> first;
    /**
     * 栈元素数量
     */
    private int size;

    @Override
    public void push(Item item) {
        // 向栈顶添加元素
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
    }

    @Override
    public Item pop() {
        // TODO: 判断栈为空
        // 从栈顶删除元素
        Item item = first.item;
        first = first.next;
        size--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
}
