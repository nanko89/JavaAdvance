import java.util.ArrayDeque;
import java.util.Scanner;

public class P04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        ArrayDeque <Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int startIndex;
            if (current == '('){
                stack.push(i);

            }else if (current == ')'){
                startIndex = stack.pop();
                String contest = input.substring(startIndex,i+1);
                System.out.println(contest);
            }

        }

    }
}
