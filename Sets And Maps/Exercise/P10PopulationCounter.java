package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P10PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Sofia|Bulgaria|1000000
        String input = scanner.nextLine();
        Map<String, Map<String, Long>> data = new LinkedHashMap<>();
        //country//city//population

        while (!input.equals("report")){
            String city = input.split("\\|")[0];
            String country = input.split("\\|")[1];
            long population = Long.parseLong(input.split("\\|")[2]);
            data.putIfAbsent(country,new LinkedHashMap<>());
            data.get(country).putIfAbsent(city, population);


            input = scanner.nextLine();

        }


        data.entrySet()
                .stream()
                .sorted((a1,a2) -> {
                    long p1 = a1.getValue().values()
                            .stream()
                            .mapToLong(l->l)
                            .sum();
                    long p2 = a2.getValue().values()
                            .stream()
                            .mapToLong(l->l)
                            .sum();
                    return Long.compare(p2,p1);
                }).forEach(c -> {
                    long totalPopulation = c.getValue().values().stream().mapToLong(l->l).sum();
            System.out.printf("%s (total population: %d)%n", c.getKey(), totalPopulation);
            Map<String, Long> cityInfo = c.getValue();
            cityInfo.entrySet().stream().sorted((a1,a2) -> Long.compare(a2.getValue(),a1.getValue()))
                    .forEach(s -> System.out.printf("=>%s: %d%n", s.getKey(),s.getValue()));
        });
        System.out.println();
    }
}
