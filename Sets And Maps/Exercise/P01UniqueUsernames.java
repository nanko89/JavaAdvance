package Exersice;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Set<String> uniqueWords = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            String word = scanner.nextLine();
            uniqueWords.add(word);
        }
        uniqueWords.forEach(System.out::println);
    }
}
