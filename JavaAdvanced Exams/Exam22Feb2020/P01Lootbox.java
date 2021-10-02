package Exam22Feb2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBox = Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt)
        .collect(Collectors.toCollection(ArrayDeque::new));
        int claimed = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int first = firstBox.peekFirst();
            int second = secondBox.peekLast();

            int result = first + second;
            if (result % 2 == 0){
                claimed += result;
                firstBox.pollFirst();
                secondBox.pollLast();
            }else {
                secondBox.pollLast();
                firstBox.offerLast(second);
            }
        }
        if (firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }
        if (claimed >= 100){
            System.out.println("Your loot was epic! Value: " + claimed);
        }else {
            System.out.println("Your loot was poor... Value: " + claimed);
        }
    }
}
