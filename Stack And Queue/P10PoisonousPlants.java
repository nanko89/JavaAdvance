import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class P10PoisonousPlants {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        String[] tokens = scanner.nextLine().split(" ");
        int[] plants = new int[numberOfPlants];
        for (int i = 0; i < numberOfPlants; i++) {
            plants[i] = Integer.parseInt(tokens[i]);
        }
        Deque<Integer> indices = new ArrayDeque<>();
        indices.push(0);
        int[] days = new int[numberOfPlants];
        for (int i = 1; i < numberOfPlants; i++) {
            int maxDays = 0;
            while (!indices.isEmpty() && plants[indices.peek()] >= plants[i]) {
                maxDays = Math.max(maxDays, days[indices.pop()]);
            }
            if (!indices.isEmpty()) {
                days[i] = maxDays + 1;
            }
            indices.push(i);
        }
        System.out.println(getLastDay(days));
    }

    private static int getLastDay(int[] days) {
        int lastDay = 0;
        for (int day : days) {
            if (day > lastDay) {
                lastDay = day;
            }
        }
        return lastDay;
    }
}
