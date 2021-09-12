import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split("\\s+");

        ArrayDeque <String> stack  = new ArrayDeque<>();
        Collections.reverse(Arrays.asList(elements));
        for (String element : elements) {
            stack.push(element);
        }

        while (stack.size() > 1){
            int sum = 0;

            int firstNum = Integer.parseInt(stack.pop());
            String sign = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if (sign.equals("+")){
                sum = firstNum + secondNum;
            }else {
                sum = firstNum - secondNum;
            }
            stack.push(sum+ "");
            if (stack.size() == 1){
                System.out.println(sum);
                break;
            }

        }


    }
}
