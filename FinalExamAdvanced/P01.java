import java.util.*;

public class P01 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numberOfIngredients = new ArrayDeque<>();

        ArrayDeque<Integer> freshnessLevel = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .filter(n -> n != 0)
                .forEach(numberOfIngredients::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(freshnessLevel::push);

        Map<String, Integer> cocktails = new TreeMap<>();

        while (!numberOfIngredients.isEmpty() && !freshnessLevel.isEmpty()) {
            int number = numberOfIngredients.peek();
            int freshness = freshnessLevel.peek();

            int result = number * freshness;

            if (result == 150) {
                cocktails.putIfAbsent("Pear Sour", 0);
                cocktails.put("Pear Sour", cocktails.get("Pear Sour") + 1);
                numberOfIngredients.poll();
                freshnessLevel.pop();
            } else if (result == 250) {
                cocktails.putIfAbsent("The Harvest", 0);
                cocktails.put("The Harvest", cocktails.get("The Harvest") + 1);
                numberOfIngredients.poll();
                freshnessLevel.pop();
            } else if (result == 300) {
                cocktails.putIfAbsent("Apple Hinny", 0);
                cocktails.put("Apple Hinny", cocktails.get("Apple Hinny") + 1);
                numberOfIngredients.poll();
                freshnessLevel.pop();
            } else if (result == 400) {
                cocktails.putIfAbsent("High Fashion", 0);
                cocktails.put("High Fashion", cocktails.get("High Fashion") + 1);
                numberOfIngredients.poll();
                freshnessLevel.pop();
            } else {
                numberOfIngredients.poll();
                freshnessLevel.pop();
                numberOfIngredients.offer(number + 5);
            }
        }
        if (cocktails.containsKey("Pear Sour") && cocktails.containsKey("The Harvest")
                && cocktails.containsKey("Apple Hinny") && cocktails.containsKey("High Fashion")){
            System.out.println("It's party time! The cocktails are ready!");
        }else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        int sum = 0;
        if (!numberOfIngredients.isEmpty()){
            while (!numberOfIngredients.isEmpty()){
                sum += numberOfIngredients.pop();
            }
        }
        if (sum > 0){
            System.out.println("Ingredients left: " + sum);
        }

        cocktails.forEach((k,v) -> System.out.printf(" # %s --> %d%n",k,v));
    }
}
