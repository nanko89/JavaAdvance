package Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class P07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> printMinElement = list -> {
          int minElement = Integer.MAX_VALUE;
            for (Integer number : list) {
                if (number < minElement){
                    minElement = number;
                }
            }
        System.out.println(list.lastIndexOf(minElement));
        };

        printMinElement.accept(numbers);
    }
}
