package ExerciseGenericBoxSwapMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Box<String> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            box.add(text);
        }
        String index = scanner.nextLine();
        int first = Integer.parseInt(index.split(" ")[0]);
        int second = Integer.parseInt(index.split(" ")[1]);

        box.swap(first,second);
        System.out.println(box);
    }
}
