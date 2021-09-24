import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class P06FindEvensOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lowerBound =scanner.nextInt();
        int upperBound = scanner.nextInt();
        scanner.nextLine();

        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> filter = getFilter(evenOrOdd);

        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream
                .rangeClosed(lowerBound,upperBound)
                .boxed()
                .filter(filter)
                .forEach(printer);
    }

    private static Predicate<Integer> getFilter(String evenOrOdd) {
        if (evenOrOdd.equals("odd")){
            return x -> x % 2 != 0;
        }
        return x -> x % 2 == 0;
    }
}
