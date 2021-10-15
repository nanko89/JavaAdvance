package LabLinearDataStructures;


import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P05SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        Collections.reverse(Arrays.asList(input));

        ArrayDeque<String> symbol = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {
            symbol.push(input[i]);
        }

        int sum = 0;

        while (symbol.size() > 1) {
            int firstNum = Integer.parseInt(symbol.pop());
            String sign = symbol.pop();
            int secondNum = Integer.parseInt(symbol.pop());

            switch (sign) {
                case "+":
                    sum = firstNum + secondNum;
                    break;
                case "-":
                    sum = firstNum - secondNum;
                    break;
            }
            symbol.push(sum + "");
        }

        if (symbol.size() == 1) {
            System.out.println(sum);
        }

    }
}
