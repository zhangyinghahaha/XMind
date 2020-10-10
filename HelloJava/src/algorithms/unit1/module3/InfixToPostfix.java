package algorithms.unit1.module3;

import algorithms.util.StdIn;
import algorithms.util.StdOut;

/**
 * @author ying.zhang01
 */
public class InfixToPostfix {

    public static String toPostfix(String infix) {
        if (infix == null) {
            return null;
        }

        Queue<String> inputQueue = new Queue<>();
        Queue<String> outputQueue = new Queue<>();
        Stack<String> operatorStack = new Stack<>();

        for (String item : infix.split(" ")) {
            inputQueue.enqueue(item);
        }

        while (!inputQueue.isEmpty()) {
            switch (inputQueue.peek()) {
                case "":
                    break;
                default:
                    break;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (s.equals("+")) stack.push(s);
            else if (s.equals("*")) stack.push(s);
            else if (s.equals(")")) StdOut.print(stack.pop() + " ");
            else if (s.equals("(")) StdOut.print("");
            else StdOut.print(s + " ");
        }
        StdOut.println();
    }
}
