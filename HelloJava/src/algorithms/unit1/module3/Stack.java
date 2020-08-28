package algorithms.unit1.module3;

import algorithms.util.StdIn;
import algorithms.util.StdOut;

public class Stack<Item> {
    private Node first;
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

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return N;
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
