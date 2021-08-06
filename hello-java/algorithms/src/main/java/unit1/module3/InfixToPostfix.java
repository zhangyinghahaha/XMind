package unit1.module3;

/**
 * @author ying.zhang01
 */
public class InfixToPostfix {

    public static Queue<String> toPostfix(String infix) {
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
            String inputElement = inputQueue.dequeue();
            String topOperator = operatorStack.peek();
            switch (inputElement) {
                case "+":
                case "-":
                case "*":
                case "/":
                    if (topOperator != null) {
                        if (operatorConvert(inputElement) >= operatorConvert(topOperator)) {
                            operatorStack.push(inputElement);
                        } else {
                            while (!operatorStack.isEmpty()) {
                                outputQueue.enqueue(operatorStack.pop());
                            }
                            operatorStack.push(inputElement);
                        }
                    } else {
                        operatorStack.push(inputElement);
                    }
                    break;
                case "(":
                    operatorStack.push(inputElement);
                    break;
                case ")":
                    while (!"(".equals(operatorStack.peek())) {
                        outputQueue.enqueue(operatorStack.pop());
                    }
                    operatorStack.pop();
                    break;
                default:
                    outputQueue.enqueue(inputElement);
                    break;
            }
        }
        while (!operatorStack.isEmpty()) {
            outputQueue.enqueue(operatorStack.pop());
        }

        return outputQueue;
    }

    public static int evaluate(String infix) {

        Queue<String> outputQueue = toPostfix(infix);

        Stack<Integer> resultStack = new Stack<Integer>();
        while (!outputQueue.isEmpty()) {
            String inputElement = outputQueue.dequeue();
            int operator1;
            int operator2;
            switch (inputElement) {
                case "+":
                    operator1 = Integer.valueOf(resultStack.pop());
                    operator2 = Integer.valueOf(resultStack.pop());
                    resultStack.push(operator2 + operator1);
                    break;
                case "-":
                    operator1 = Integer.valueOf(resultStack.pop());
                    operator2 = Integer.valueOf(resultStack.pop());
                    resultStack.push(operator2 - operator1);
                    break;
                case "*":
                    operator1 = Integer.valueOf(resultStack.pop());
                    operator2 = Integer.valueOf(resultStack.pop());
                    resultStack.push(operator2 * operator1);
                    break;
                case "/":
                    operator1 = Integer.valueOf(resultStack.pop());
                    operator2 = Integer.valueOf(resultStack.pop());
                    resultStack.push(operator2 / operator1);
                    break;
                default:
                    resultStack.push(Integer.valueOf(inputElement));
                    break;
            }
        }

        return resultStack.pop();
    }

    private static int operatorConvert(String operator) {
        int operatorInteger = 0;
        switch (operator) {
            case "+":
            case "-":
                operatorInteger = 1;
                break;
            case "*":
            case "/":
                operatorInteger = 2;
                break;
            default:
                break;
        }
        return operatorInteger;
    }

    public static void main(String[] args) {
    }
}
