import java.util.Arrays;
import java.util.Scanner;


public class P02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int sum = Arrays.stream(numbers).sum();
        long count = Arrays.stream(numbers).count();

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);


    }
}
