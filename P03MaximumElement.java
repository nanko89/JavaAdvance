
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P03MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            if (input.equals("2")){
                stack.pop();
            }else if (input.equals("3")){
                System.out.println(Collections.max(stack));
            }else {
                int[] push = Arrays.stream(input.split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                int elements = push[1];
                stack.push(elements);
            }
        }

    }
}
