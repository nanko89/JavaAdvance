package Lab;

import java.util.*;
import java.util.stream.Collectors;

public class P08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudent =Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> data = new TreeMap<>();

        for (int i = 0; i < numberOfStudent; i++) {
            String name = scanner.nextLine();
            List<Double> grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Double::parseDouble)
                    .collect(Collectors.toList());
            data.putIfAbsent(name,new ArrayList<>());
            data.get(name).addAll(grades);

        }
        data.entrySet()
                .stream()
                .forEach(entry -> {
                    //George is graduated with 4.351249999999999
                    System.out.printf("%s is graduated with ", entry.getKey());
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double average = sum / entry.getValue().size();
                    System.out.println(average);
                });
    }
}
