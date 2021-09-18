package Exersice;

import java.util.*;

public class P11LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Integer> dataDuration = new TreeMap<>();
        Map<String, Set<String>> dataIP = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            String ip = input.split("\\s+")[0];
            String name = input.split("\\s+")[1];
            int duration = Integer.parseInt(input.split("\\s+")[2]);

            if (!dataIP.containsKey(name)) {
                dataIP.put(name, new TreeSet<>());
                if (!dataIP.get(name).contains(ip)) {
                    dataIP.get(name).add(ip);
                    dataDuration.put(name, duration);
                }else {
                    dataDuration.put(name, dataDuration.get(name) + duration);
                }

            } else {
                    dataIP.get(name).add(ip);
                    dataDuration.put(name, dataDuration.get(name) + duration);
            }
        }
        dataIP.forEach((key, value) -> System.out.printf("%s: %d [%s]%n", key, dataDuration.get(key), String.join(", ", value)));
    }
}
