package basic.datatype;

import utils.StdIn;
import utils.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Queue implementation with a resizing arry(wrap-around).
 *
 * @author ying.zhang01
 */
public class ResizingArrayQueue<Item> {
    private final static int MIN_SIZE = 5;
    private Item[] q;
    private int size = 0;
    private int first = 0;
    private int last = 0;

    ResizingArrayQueue() {
        q = (Item[]) new Object[MIN_SIZE];
    }

    public void enqueue(Item item) {
        if (size == q.length) {
            resize(2 * q.length);
        }
        q[last++] = item;
        if (last == q.length) {
            // wrap-around
            last = 0;
        }
        size++;
    }

    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Item item = q[first];
        // to avoid loitering
        q[first] = null;
        size--;
        first++;
        if (first == q.length) {
            // wrap-around
            first = 0;
        }
        if (size > 0 && size == q.length / 4) {
            resize(q.length / 2);
        }
        return item;
    }

    public Item peek() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return q[first];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = this.size + ": ";
        for (int i = 0; i < size; i++) {
            result += q[i] + " ";
        }
        return result;
    }

    private void resize(int max) {
        assert max > size;
        Item[] copy = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            // (first + 1) % q.length
            copy[i] = q[(first + i) % q.length];
        }
        q = copy;
        first = 0;
        last = size;
    }

    private class ArrayIterator implements Iterator<Item> {
        private int i = 0;

        @Override
        public boolean hasNext() {
            return i < size;
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
            Item item = q[(i + first) % q.length];
            i++;
            return item;
        }
    }

    public static void main(String[] args) {
        int num = 0;
        ResizingArrayQueue<String> queue = new ResizingArrayQueue();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if ("-".equals(s)) {
                StdOut.println(queue.dequeue());
            } else {
                queue.enqueue(s);
                StdOut.println(++num);
            }
        }
        StdOut.println(queue);
    }
}
