package Exercise;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P10PredicateParty {
    static List<String> names = null;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();

        while (!input.equals("Party!")) {
        String[] tokens = input.split("\\s+");
        String currentCommand = tokens[0];
        switch (currentCommand){
            case "Remove":
                removeName(getPredicate(tokens));
               break;
            case "Double":
                addOneMore(getPredicate(tokens));
                break;
        }
            input = scanner.nextLine();
        }
        if (names.isEmpty()){
            System.out.println("Nobody is going to the party!");
        }else {
            Collections.sort(names);
            System.out.println(String.join(", ", names) + " are going to the party!");
        }
    }

    private static void removeName(Predicate<String> predicate) {
        names.removeIf(predicate);
    }

    private static void addOneMore(Predicate<String> predicate) {
        List<String> namesToAdd = new ArrayList<>();
        names.stream().filter(predicate).forEach(namesToAdd::add);
        names.addAll(namesToAdd);
    }

    private static Predicate<String> getPredicate(String[] tokens) {
        Predicate<String> predicate;
        if (tokens[1].equals("StartsWith")){
            predicate = name -> name.startsWith(tokens[2]);
        }else if (tokens[1].equals("EndsWith")){
            predicate = name -> name.endsWith(tokens[2]);
        }else {
            predicate = name -> name.length() == Integer.parseInt(tokens[2]);
        }
        return predicate;
    }


}

