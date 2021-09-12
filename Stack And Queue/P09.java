import java.util.ArrayDeque;
import java.util.Scanner;

public class P09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();
        for (String token : input) {
            if (!"-+/*()".contains(token)) {
                outputQueue.offer(token);
            } else if (token.equals("(")) {
                operatorStack.push(token);
            } else if (token.equals(")")) {
                while (!operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                if ("-+".contains(token)) {
                    while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                        outputQueue.offer(operatorStack.pop());
                    }
                } else {
                    while (!operatorStack.isEmpty() && !"+-(".contains(operatorStack.peek())) {
                        outputQueue.offer(operatorStack.pop());
                    }
                }
                operatorStack.push(token);
            }
        }
        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }
        System.out.println(String.join(" ", outputQueue));

    }
}
