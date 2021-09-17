package Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,Map<String, Double>> foodShops = new TreeMap<>();

        String input = scanner.nextLine();

        while (!input.equals("Revision")){
            String shopName = input.split(", ")[0];
            String product = input.split(", ")[1];
            double price = Double.parseDouble(input.split(", ")[2]);

            foodShops.putIfAbsent(shopName, new LinkedHashMap<>());
            foodShops.get(shopName).put(product, price);

            input = scanner.nextLine();

        }
        foodShops.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue()
                            .entrySet()
                            .stream()
                            .forEach(e -> System.out.printf("Product: %s, Price: %.1f%n", e.getKey(),e.getValue()));

                });
    }
}
//Product: apple, Price: 1.2
