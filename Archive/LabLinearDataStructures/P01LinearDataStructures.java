package LabLinearDataStructures;

import java.util.Arrays;
import java.util.Scanner;


public class P01LinearDataStructures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());
        int [] numbers = new int[numberOfStrings];


        for (int i = 0; i < numberOfStrings; i++) {
            int currentSum = 0;
            String word = scanner.nextLine();
            for (int j = 0; j <word.length() ; j++) {
                char symbol = word.charAt(j);
                if (symbol == 65 || symbol == 69 || symbol == 73 || symbol == 79 || symbol == 85
                        || symbol == 97 || symbol == 101 || symbol == 105 || symbol == 111 || symbol == 117){
                    currentSum += symbol * word.length();
                }else {
                    currentSum += symbol / word.length();
                }

            }
            numbers [i] = currentSum;


        }
        Arrays.sort(numbers);
        for (int i = 0; i < numberOfStrings; i++) {
            System.out.println(numbers[i]);
        }

    }
}
