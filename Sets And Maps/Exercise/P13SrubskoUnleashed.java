package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P13SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "(?<singer>[A-Za-z ]+) @(?<venue>[A-Za-z ]+) (?<ticketPrice>[0-9]+) (?<ticketCount>[0-9]+)";
        Pattern pattern = Pattern.compile(regex);
        Map<String, Map<String ,Integer>> data = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!input.equals("End")){
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()){
                String singer = matcher.group("singer");
                String venue = matcher.group("venue");
                int ticketPrice = Integer.parseInt(matcher.group("ticketPrice"));
                int ticketCount = Integer.parseInt(matcher.group("ticketCount"));
                int totalMoney =  ticketCount * ticketPrice;

                data.putIfAbsent(venue, new LinkedHashMap<>());
                data.get(venue).putIfAbsent(singer,0);
                data.get(venue).put(singer,data.get(venue).get(singer) + totalMoney);

            }

            input = scanner.nextLine();

        }
        data.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey());
                    entry.getValue().entrySet()
                            .stream()
                            .sorted((s1,s2) -> Integer.compare(s2.getValue(),s1.getValue()))
                            .forEach(e -> System.out.printf("#  %s -> %d%n", e.getKey(),e.getValue())
                                    );
                });
    }
}
