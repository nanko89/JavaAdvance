import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class P04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int offerElement = scanner.nextInt();
        int pollElement = scanner.nextInt();
        int currentElement = scanner.nextInt();

        ArrayDeque<Integer> stackNumbers = new ArrayDeque<>();
        for (int i = 0; i < offerElement; i++) {
            stackNumbers.offer(scanner.nextInt());
        }

        for (int i = 0; i < pollElement; i++) {
            stackNumbers.poll();
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
