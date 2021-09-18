package Exersice;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<Character, Integer> data = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            int currentValue = data.getOrDefault(current, 0);
            data.put(current, currentValue + 1);
         //data.putIfAbsent(current, 0);
            // data.put(current, data.get(current) + 1);
        }
        data.forEach((e,k) -> System.out.printf("%c: %d time/s%n", e,k));
    }
}
