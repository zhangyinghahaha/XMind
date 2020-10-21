package algorithms.unit1.module3;

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
            String inputElement = inputQueue.peek();
            String topOperator = operatorStack.peek();
            switch (inputElement) {
                case "+":
                    if (topOperator != null) {
                        if (operatorConvert(inputElement) > operatorConvert(topOperator)) {
                            
                        }
                    }
                    break;
                case "-":
                    break;
                case "*":
                    break;
                case "/":
                    break;
                default:
                    outputQueue.enqueue(inputQueue.dequeue());
                    break;
            }
        }

        return null;
    }

    private static int operatorConvert(String operator) {
        int operatorInteger = 0;
        switch (operator) {
            case "+":
                operatorInteger = 1;
                break;
            case "-":
                operatorInteger = 1;
                break;
            case "*":
                operatorInteger = 2;
                break;
            case "/":
                operatorInteger = 2;
                break;
            default:
                break;
        }
        return operatorInteger;
    }

    public static void main(String[] args) {
        // A + B * C - D
    }
}
