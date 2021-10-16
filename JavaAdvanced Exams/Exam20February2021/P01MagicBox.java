package Exam20February2021;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class P01MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstMagicBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondMagicBox = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(firstMagicBox::offer);

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .forEach(secondMagicBox::push);
        int collection = 0;
        while (!firstMagicBox.isEmpty() && !secondMagicBox.isEmpty()){
            int firstBox = firstMagicBox.peek();
            int secondBox = secondMagicBox.peek();
            int result = firstBox + secondBox;
            if (result %  2 == 0){
                collection += result;
                firstMagicBox.poll();
                secondMagicBox.pop();
            }else {
                secondMagicBox.pop();
                firstMagicBox.offer(secondBox);
            }


        }
            if (firstMagicBox.isEmpty()){
                System.out.println("First magic box is empty.");
            }else {
                System.out.println("Second magic box is empty.");
            }

            if (collection >= 90){
                System.out.println("Wow, your prey was epic! Value: " + collection);
            }else {
                System.out.println("Poor prey... Value: " + collection);
            }

    }
}
