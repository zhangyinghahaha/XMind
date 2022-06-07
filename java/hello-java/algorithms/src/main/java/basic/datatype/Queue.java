package basic.datatype;

import utils.StdIn;
import utils.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Test class
 *
 * @author zhangying
 * @date 2020/9/1
 */
public class Queue<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    Queue() {
    }

    public void enqueue(Item item) {
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;

        if (isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        N++;
    }

    public Item peek() {
        if (isEmpty()) {
            return null;
        }
        Item item = first.item;
        return item;
    }

    public Item dequeue() {
        Item item = first.item;
        first = first.next;

        if (isEmpty()) {
            last = null;
        }
        N--;
        return item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    public Item deleteNode(int k) {
        return null;
    }

    public Item removeLast() {
        // 空节点
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node oldLast = last;
        // 单节点
        if (first == last) {
            last = null;
            first = null;
            return oldLast.item;
        }

        Node current = first;
        while (current.next != last) {
            current = current.next;
        }
        current.next = null;
        last = current;

        return oldLast.item;
    }

    @Override

    public Iterator<Item> iterator() {
        return null;
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

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

    private class Node {
        Item item;
        Node next;
    }

    public Node reverse(Node x) {
        Node first = x;
        Node reverse = null;
        Node second = null;

        while (first != null) {
            second = first.next;
            first.next = reverse;
            reverse = first;
            first = second;
        }

        return reverse;
    }


    public static void main(String[] args) {
        Queue<String> q = new Queue<>();

        while (!utils.StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) {
                q.enqueue(item);
            } else if (!q.isEmpty()) {
                StdOut.print(q.dequeue() + " ");
            }
        }
    }
}
