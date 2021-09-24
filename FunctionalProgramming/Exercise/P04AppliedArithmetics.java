package Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class P04AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], int[]> add = array -> Arrays.stream(array).map(e -> e + 1).toArray();
        Function<int[], int[]> subtract = array -> Arrays.stream(array).map(e -> e - 1).toArray();
        Function<int[], int[]> multiply = array -> Arrays.stream(array).map(e -> e * 2).toArray();
        Consumer<int[]> print = array -> Arrays.stream(array).forEach(e-> System.out.print(e + " "));

        String input = scanner.nextLine();
        while (!input.equals("end")){
            switch (input){
                case "add":
                    numbers = add.apply(numbers);
                    break;
                case "subtract":
                   numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "print":
                   print.accept(numbers);
                    System.out.println();
                    break;
            }

            input = scanner.nextLine();

        }

    }
}
