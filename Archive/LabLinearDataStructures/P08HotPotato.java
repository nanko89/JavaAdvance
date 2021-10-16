package LabLinearDataStructures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class P08HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();
        Arrays.stream(names).forEach(queue::offer);

        while (queue.size() > 1) {
            for (int i = 1; i < n; i++) {
                queue.offer(Objects.requireNonNull(queue.poll()));
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}



