package algorithms.unit1.module3;

import algorithms.util.StdIn;
import algorithms.util.StdOut;

/**
 * Parentheses class
 *
 * @author zhangying
 * @date 2020/9/1
 */
public class Parentheses {
    private static final char LEFT_PAREN     = '(';
    private static final char RIGHT_PAREN    = ')';
    private static final char LEFT_BRACE     = '{';
    private static final char RIGHT_BRACE    = '}';
    private static final char LEFT_BRACKET   = '[';
    private static final char RIGHT_BRACKET  = ']';

    public static boolean isBalance(String s) {
        if (s == null) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case LEFT_PAREN :
                case LEFT_BRACE :
                case LEFT_BRACKET :
                    stack.push(s.charAt(i));
                    break;
                case RIGHT_PAREN:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.pop().equals(LEFT_PAREN)) {
                        return false;
                    }
                    break;
                case RIGHT_BRACE :
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.pop().equals(LEFT_BRACE)) {
                        return false;
                    }
                    break;
                case RIGHT_BRACKET :
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.pop().equals(LEFT_BRACKET)) {
                        return false;
                    }
                    break;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Stack<String> s = new Stack<>();

        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            StdOut.println(isBalance(item));
        }
    }
}
