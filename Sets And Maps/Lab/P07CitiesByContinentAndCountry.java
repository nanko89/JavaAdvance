package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String,List<String>>> data = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String continent = input.split("\\s+")[0];
            String country = input.split("\\s+")[1];
            String city = input.split("\\s+")[2];

            data.putIfAbsent(continent, new LinkedHashMap<>());
            data.get(continent).putIfAbsent(country,new ArrayList<>());
            data.get(continent).get(country).add(city);

        }
        data.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + ":");
                    entry.getValue()
                            .forEach((k,v) -> {
                                System.out.printf("  %s -> %s%n",
                                        k, String.join(", ", v));
                            } );
                });
    }
}
