package Lab;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P04CountRealNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double,Integer> digits = new LinkedHashMap<>();
        for (double v : input) {
            digits.putIfAbsent(v, 0);
            digits.put(v, digits.get(v) + 1);
        }
        digits.forEach((k,v) -> System.out.printf("%.1f -> %d%n", k,v));
    }
}
