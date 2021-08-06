package unit1.module3;

import util.StdIn;
import util.StdOut;

/**
 * @author ying.zhang01
 */
public class EvaluatePostfix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            switch (s) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        StdOut.println(stack.pop());
    }
}
