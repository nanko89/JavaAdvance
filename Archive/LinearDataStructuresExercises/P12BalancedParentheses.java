package LinearDataStructuresExercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P12BalancedParentheses {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<Character> parentheses = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                parentheses.push(current);
            } else if (!parentheses.isEmpty()){
                char stack = parentheses.pop();
                if ((current == '}' && stack != '{')
                        || (current == ')' && stack != '(')
                        || (current == ']' && stack != '[')) {
                    isBalanced = false;
                    break;
                }
            }else {
                isBalanced = false;
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
