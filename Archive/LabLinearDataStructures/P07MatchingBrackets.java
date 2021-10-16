package LabLinearDataStructures;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text  = scanner.nextLine();

        ArrayDeque<Integer> index = new ArrayDeque<>();

        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);

            if (current == '('){
                index.push(i);
            }else if (current== ')'){
               String print = text.substring(index.pop(),i+1);
                System.out.println(print);
            }
        }

    }
}
