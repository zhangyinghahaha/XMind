package algorithms.unit1.module3;

import algorithms.util.StdIn;
import algorithms.util.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    /**
     * top of stack
     */
    private Node first;
    /**
     * size of the stack
     */
    private int N;

    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
    }

    public Item pop() {
        // 检查是否为空
        if (isEmpty()) {
            StdOut.print("Stack is Empty!");
            return null;
        }
        Item item = first.item;
        first = first.next;
        N--;
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            StdOut.println("Stack is Empty!");
            return null;
        }
        return first.item;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
    }

    /**
     * Returns a string representation of this stack.
     *
     * @return the sequence of items in this stack in LIFO order, separated by spaces
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    @Override
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    /**
     * an iterator, doesn't implement remove() since it's optional
     */
    private class LinkedIterator implements Iterator<Item> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    private class Node {
        Item item;
        Node next;
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-") && !item.equals("exit")) {
                s.push(item);
            } else if (item.equals("-")) {
                StdOut.print(s.pop() + " ");
            } else if (item.equals("exit")) {
                break;
            }
        }

        StdOut.println("(" + s.size() + " left on stack)");
    }
}
