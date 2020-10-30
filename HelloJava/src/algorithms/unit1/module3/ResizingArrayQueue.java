package algorithms.unit1.module3;

import algorithms.util.StdIn;
import algorithms.util.StdOut;

/**
 * Queue implementation with a resizing arry(wrap-around).
 *
 * @author ying.zhang01
 */
public class ResizingArrayQueue<Item> {
    private final static int MIN_SIZE = 10;
    private Item[] q;
    private int size = 0;

    ResizingArrayQueue() {
        q = (Item[]) new Object[MIN_SIZE];
    }

    public void enqueue(Item item) {
        if (size == q.length) {
            resize(2 * q.length);
        }
        q[size++] = item;
    }

    public Item dequeue() {
        if (size < 1) {
            System.out.println("Queue is empty!");
            return null;
        }

        if (size <= q.length / 4) {
            resize(q.length / 2);
        }
        Item oldfirst = q[0];
        size--;
        for (int i = 0; i < size; i++) {
            q[i] = q[i + 1];
        }

        return oldfirst;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void resize(int max) {
        Item[] temp = (Item[]) new Object[max];
        for (int i = 0; i < size; i++) {
            temp[i] = q[i];
        }
        q = temp;
    }

    @Override
    public String toString() {
        String result = this.size + ": ";
        for (int i = 0; i < size; i++) {
            result += q[i] + " ";
        }
        return result;
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
