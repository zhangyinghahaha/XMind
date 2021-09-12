package basic.datatype.impl;

import basic.datatype.api.Bag;

import java.util.Iterator;

/**
 * @author zhangying
 */
public class LinkedBag<Item> implements Bag<Item> {
    /**
     * 链表的首节点
     */
    private Node<Item> first;
    private int size;

    @Override
    public void add(Item item) {
        Node<Item> oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        size++;
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
