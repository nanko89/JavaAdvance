package Exersice;

import java.util.*;

public class P14DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<Double>>> data = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            double damage;
            double health;
            double armor;
            if (input[2].equals("null")) {
                damage = 45;
            } else {
                damage = Double.parseDouble(input[2]);
            }

            if (input[3].equals("null")) {
                health = 250;
            } else {
                health = Double.parseDouble(input[3]);
            }

            if (input[4].equals("null")) {
                armor = 10;
            } else {
                armor = Double.parseDouble(input[4]);
            }

            List<Double> parameter = new ArrayList<>();

            parameter.add(damage);
            parameter.add(health);
            parameter.add(armor);

            data.putIfAbsent(type, new TreeMap<>());
            data.get(type).put(name, parameter);

        }
        data.entrySet()
                .stream()
                .forEach(entry -> {
                    double averageDamage = entry.getValue().values().stream().mapToDouble(d -> d.get(0)).average().orElse(0);
                    double averageHealth = entry.getValue().values().stream().mapToDouble(d -> d.get(1)).average().orElse(0);
                    double averageArmor = entry.getValue().values().stream().mapToDouble(d -> d.get(2)).average().orElse(0);
                    System.out.printf("%s::(%.2f/%.2f/%.2f)%n", entry.getKey(), averageDamage, averageHealth, averageArmor);
                    entry.getValue().entrySet()
                            .stream().forEach(e -> {
                        System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                                e.getKey(), e.getValue().get(0), e.getValue().get(1), e.getValue().get(2));
                    });
                });

    }
}
