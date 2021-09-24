package Exercise;

import java.util.Arrays;

import java.util.Scanner;


public class P03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int min = Arrays.stream(numbers).min().getAsInt();

        System.out.println(min);


    }
}
