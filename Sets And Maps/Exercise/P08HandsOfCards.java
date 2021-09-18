package Exersice;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class P08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("JOKER")) {
            String name = input.split(":")[0];
            List<String> cards = Arrays.stream(input.split(": ")[1].split(",\\s+"))
                    .collect(Collectors.toList());
            players.putIfAbsent(name, new LinkedHashSet<>());
            players.get(name).addAll(cards);

            input = scanner.nextLine();

        }
        String regex = "([0-9]+|[JQKA])([HDSC])";
        Pattern pattern = Pattern.compile(regex);

        for (Map.Entry<String, Set<String>> entry : players.entrySet()) {
            int playerScore = 0;
            for (String cards : entry.getValue()){
                Matcher matcher = pattern.matcher(cards);
                if (matcher.find()){
                    String power = matcher.group(1);
                    String type = matcher.group(2);

                    int value = getValueByPower(power);
                    int multiply = getMultiplyByType(type);
                    playerScore += value * multiply;
                }
            }
            System.out.println(entry.getKey() + ": " + playerScore);
        }

    }

    private static int getMultiplyByType(String type) {
        int multiply = 0;

        switch (type){
            case "S":
                multiply = 4;
                break;
            case "H":
                multiply = 3;
                break;
            case "D":
                multiply = 2;
                break;
            case "C":
                multiply = 1;
                break;
        }
        return multiply;
    }

    private static int getValueByPower(String power) {
        int value;
        switch (power){
            case "K":
                value = 13;
                break;
            case "Q":
                value = 12;
                break;
            case "J":
                value = 11;
                break;
            case "A":
                value = 14;
                break;
            default:
                value = Integer.parseInt(power);
        }
        return value;
    }
}

