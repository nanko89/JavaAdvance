package Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        Map<String, Predicate<String>> predicates = new HashMap<>();


        while (!input.equals("Print")) {
            String[] tokens = input.split(";");
            String currentCommand = tokens[0];
            String predicateName = tokens[1]  + tokens[2];
            if (tokens[0].contains("Add")) {
                Predicate<String> predicate = getPredicate(tokens);
                predicates.put(predicateName, predicate);
            } else {
                predicates.remove(predicateName);
            }
            input = scanner.nextLine();
        }
        names.stream().filter(guest -> {
            boolean isValid = true;
            for (Predicate<String> value : predicates.values()) {
                if (value.test(guest)) {
                    isValid = false;
                    break;
                }
            }
            return isValid;
        }).forEach(e -> System.out.print(e + " "));
    }


    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate = null;
        switch (tokens[1]) {
            case "Starts with":
                predicate = name -> name.startsWith(tokens[2]);
                break;
            case "Ends with":
                predicate = name -> name.endsWith(tokens[2]);
                break;
            case "Length":
                predicate = name -> name.length() == Integer.parseInt(tokens[2]);
                break;
            case "Contains":
                predicate = name -> name.contains(tokens[2]);
                break;
        }
        return predicate;
    }
}
