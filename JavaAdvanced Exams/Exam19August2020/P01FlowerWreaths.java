package Exam19August2020;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(lilies::push);

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .forEach(roses::offer);
        int wreaths = 0;
        int storeFlower = 0;
        while (!lilies.isEmpty() && !roses.isEmpty() && wreaths < 5) {
            int lily = lilies.peek();
            int rose = roses.peek();

            int result = lily + rose;

            if (result == 15) {
                lilies.pop();
                roses.poll();
                wreaths++;
            } else if (result > 15) {
                int lastLily = lilies.pop() - 2;
                lilies.push(lastLily);
            } else {
                lilies.pop();
                roses.poll();
                storeFlower += result;
            }
        }
        if (storeFlower > 15) {
            wreaths += storeFlower / 15;
        }
        if (wreaths >= 5) {
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        } else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}

