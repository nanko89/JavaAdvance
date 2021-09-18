package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Integer> materials = new LinkedHashMap<>();

        while (!input.equals("stop")){
            String material = input;
            int quantity = Integer.parseInt(scanner.nextLine());

            materials.putIfAbsent(material, 0);
            materials.put(material, materials.get(material) + quantity);


            input = scanner.nextLine();
        }
        materials.forEach((k,v) -> System.out.println(k + " -> " + v));

    }
}
