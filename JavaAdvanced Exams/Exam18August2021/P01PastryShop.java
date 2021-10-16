package Exam18August2021;

import java.util.*;

public class P01PastryShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> liquidsQueue = new ArrayDeque<>();
        ArrayDeque<Integer> ingredientsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(liquidsQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(ingredientsStack::push);

        Map<String, Integer> products = new LinkedHashMap<>();
        products.put("Biscuit", 0);
        products.put("Cake", 0);
        products.put("Pie", 0);
        products.put("Pastry", 0);

        while (!liquidsQueue.isEmpty() && !ingredientsStack.isEmpty()){

            int liquids = liquidsQueue.poll();

            int ingredients = ingredientsStack.pop();

            int result = liquids + ingredients;

            if (result == 25){
                products.put("Biscuit", products.get("Biscuit") + 1);
            }else if (result == 50){
                products.put("Cake", products.get("Cake") + 1);
            }else if (result == 75){
                products.put("Pastry", products.get("Pastry") + 1);
            }else if (result == 100){
                products.put("Pie", products.get("Pie") + 1);
            }else {
                ingredientsStack.push(ingredients + 3);
            }
        }
        boolean findAllProduct = products.entrySet().stream().allMatch((k) -> k.getValue() >= 1);
        if (findAllProduct){
            System.out.println("Great! You succeeded in cooking all the food!");
        }else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }

        printDeque("Liquids left: ", liquidsQueue);
        printDeque("Ingredients left: ", ingredientsStack);

        products.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    private static void printDeque(String name, ArrayDeque<Integer> arrayDeque) {
        if (arrayDeque.isEmpty()){
            System.out.println(name + "none");
        }else {
            System.out.println(name + arrayDeque.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
