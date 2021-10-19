package Exam16December2020;

import java.util.*;

public class P01Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(liquidQueue::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(ingredientStack::push);

        Map<String, Integer> items = new TreeMap<>();
        items.put("Bread", 0);
        items.put("Cake", 0);
        items.put("Fruit Pie", 0);
        items.put("Pastry", 0);

        while (!liquidQueue.isEmpty() && ! ingredientStack.isEmpty()){
            int liquids = liquidQueue.poll();
            int ingredients = ingredientStack.pop();
            int sum = liquids + ingredients;

            if (sum == 25){
                items.put("Bread", items.get("Bread") + 1);

            }else if (sum == 50){
                items.put("Cake", items.get("Cake") + 1);

            }else if (sum == 75){
                items.put("Pastry",items.get("Pastry") + 1);

            }else if (sum == 100){
                items.put("Fruit Pie", items.get("Fruit Pie") + 1);

            }else {
                ingredients =  ingredients + 3;
                ingredientStack.push(ingredients);
            }
        }
        if (items.entrySet().stream().allMatch(i -> i.getValue() >= 1)){
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        printDeque(liquidQueue, "Liquids");
        printDeque(ingredientStack, "Ingredients");
        items.forEach((key, value) -> System.out.println(key + ": " + value));

    }

    private static void printDeque(ArrayDeque<Integer> deque, String string) {
        if (deque.isEmpty()){
            System.out.println(string +" left: none");
        }else {
            System.out.println(string +" left: " + deque.toString().replaceAll("[\\[\\]]",""));
        }
    }
}
