
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class P05FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> info = new LinkedHashMap<>();

        while (n-- > 0){
            String[] input= scanner.nextLine().split(",\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);
            info.put(name,age);
        }
        String condition = scanner.nextLine();
        int currentAge =Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        info.entrySet().stream()
                .filter(getAgeFilter(currentAge,condition))
                .forEach(getFormatter(format));

    }
    private static Predicate<Map.Entry<String, Integer>> getAgeFilter
            (int currentAge, String condition){
        if (condition.equals("older")){
            return e -> e.getValue() >= currentAge;
        }
        return e -> e.getValue() <= currentAge;
    }

    private static Consumer<Map.Entry<String, Integer>> getFormatter
            (String format){
        if (format.equals("name")){
            return entry -> System.out.println(entry.getKey());

        }else if (format.equals("age")){
            return  entry -> System.out.println(entry.getValue());
        }else {
            return entry -> System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
