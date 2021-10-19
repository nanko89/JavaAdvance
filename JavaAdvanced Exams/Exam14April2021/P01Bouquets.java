package Exam14April2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tulipsStack = new ArrayDeque<>();
        ArrayDeque<Integer> daffodilsQueue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tulipsStack::push);

        Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(daffodilsQueue::offer);
        int bouquet = 0;
        int storeFlower = 0;
        while (!tulipsStack.isEmpty() && !daffodilsQueue.isEmpty()) {
            int tulips = tulipsStack.peek();
            int daffodils = daffodilsQueue.peek();
            int result = tulips + daffodils;
            if (result == 15) {
                bouquet++;
                tulipsStack.pop();
                daffodilsQueue.poll();
            } else if (result > 15) {
                tulipsStack.pop();
                tulipsStack.push(tulips - 2);
            } else {
                storeFlower += result;
                tulipsStack.pop();
                daffodilsQueue.poll();
            }

        }
        if (storeFlower > 15){
            bouquet += storeFlower / 15;
        }
        if (bouquet >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquet);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquet);
        }
    }
}
