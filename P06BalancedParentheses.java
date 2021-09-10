import java.util.ArrayDeque;
import java.util.Scanner;

public class P06BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");

        ArrayDeque<String> parenthesis = new ArrayDeque<>();

        boolean isBalnced = false;

        for (String currentParenthesis : input) {
            if (currentParenthesis.equals("(") || currentParenthesis.equals("{")|| currentParenthesis.equals("[") ) {
                parenthesis.push(currentParenthesis);
            } else {
                if (parenthesis.isEmpty()){
                    isBalnced = false;
                    break;
                }
                if (currentParenthesis.equals(")")) {
                    if (parenthesis.poll().equals("(")) {
                        isBalnced = true;

                    } else {
                        isBalnced = false;
                        break;
                    }
                } else if (currentParenthesis.equals("}")) {
                    if (parenthesis.poll().equals("{")) {
                        isBalnced = true;
                    } else {
                        isBalnced = false;
                        break;
                    }
                } else if (currentParenthesis.equals("]")) {
                    if (parenthesis.poll().equals("[")) {
                        isBalnced = true;
                    } else {

                        isBalnced = false;
                        break;
                    }
                }
            }
        }
        if (parenthesis.isEmpty() && isBalnced){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
