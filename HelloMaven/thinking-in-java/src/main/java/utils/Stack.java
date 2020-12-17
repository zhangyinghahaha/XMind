package utils;

import java.util.LinkedList;

/**
 * Stack class
 *
 * @author ying.zhang01
 * @date 2019/4/28
 */
public class Stack<T> {
    private LinkedList<T> storage = new LinkedList<T>();

    public void push(T v) {
        storage.addFirst(v);
    }
    public T peek() {
        return storage.getFirst();
    }
    public T pop() {
        return storage.removeFirst();
    }
    public boolean empty() {
        return storage.isEmpty();
    }
    @Override
    public String toString() {
        return storage.toString();
    }

    private static void hi() {}
}
