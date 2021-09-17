package Exersice;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstSet = scanner.nextInt();
        int secondSet = scanner.nextInt();
        scanner.nextLine();
        Set<Integer> first = new LinkedHashSet<>();
        Set<Integer> second = new LinkedHashSet<>();

        for (int i = 0; i < firstSet; i++) {
            first.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < secondSet; i++) {
            second.add(Integer.parseInt(scanner.nextLine()));
        }

        first.forEach(e -> {
            if (second.contains(e)){
                System.out.print(e + " ");
            }
        } );
    }
}
