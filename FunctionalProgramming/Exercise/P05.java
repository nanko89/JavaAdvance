package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        Collections.reverse(numbers);

        int divider = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> check = number -> number % divider == 0;

        numbers.removeIf(check);

        Consumer<List<Integer>> printNumber = list -> list.forEach( e -> System.out.print(e + " "));

        printNumber.accept(numbers);

    }
}
