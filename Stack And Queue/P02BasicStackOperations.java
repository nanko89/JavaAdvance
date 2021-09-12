import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pushElement = scanner.nextInt();
        int popElement = scanner.nextInt();
        int currentElement = scanner.nextInt();

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        for (int i = 0; i < pushElement; i++) {
            stackNumbers.push(scanner.nextInt());
        }

        for (int i = 0; i < popElement; i++) {
            stackNumbers.pop();
        }


        if (stackNumbers.isEmpty()) {
            System.out.println(0);
        } else if (stackNumbers.contains(currentElement)) {
            System.out.println(true);
        } else {
            System.out.println(Collections.min(stackNumbers));
        }
    }
}

