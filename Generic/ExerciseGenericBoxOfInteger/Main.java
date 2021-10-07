package ExerciseGenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Integer> integerBox = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            integerBox.add(num);
        }
        System.out.print(integerBox.toString());
    }
}
