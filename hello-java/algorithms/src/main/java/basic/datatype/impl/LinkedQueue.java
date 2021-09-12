package basic.datatype.impl;

import basic.datatype.api.Queue;

import java.util.Iterator;

/**
 * @author zhangying
 */
public class LinkedQueue<Item> implements Queue<Item> {
    /**
     * 队列的开头
     */
    private Node<Item> first;
    /**
     * 队列的结尾
     */
    private Node<Item> last;
    /**
     * 队列中的元素数量
     */
    private int size;

    @Override
    public void enqueue(Item item) {
        Node<Item> oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    @Override
    public Item dequeue() {
        // TODO: 判空
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
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
