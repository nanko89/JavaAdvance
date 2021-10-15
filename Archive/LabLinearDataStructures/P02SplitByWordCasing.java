package LabLinearDataStructures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;


public class P02SplitByWordCasing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> sentence = Arrays.stream(scanner.nextLine()
                .split("[ \\[\\],;\\\\:.!/()\"']+"))
                .collect(Collectors.toCollection(ArrayList::new));

        ArrayList<String> lowerCaseWords = new ArrayList<>();
        ArrayList<String> mixedCaseWords = new ArrayList<>();
        ArrayList<String> upperCaseWords = new ArrayList<>();

        for (String word : sentence)
        {
            boolean isMixed = false;
            for (int i = 0; i < word.length(); i++)
            {
                if (!Character.isLetter(word.charAt(i)))
                {
                    isMixed = true;
                    break;
                }
            }
            if (word.toUpperCase().equals(word) && !isMixed && !word.isEmpty()){
                upperCaseWords.add(word);
            } else if (word.toLowerCase().equals(word) && !isMixed && !word.isEmpty()) {
                lowerCaseWords.add(word);
            } else if (!word.isEmpty()){
                mixedCaseWords.add(word);
            }
        }
        System.out.println("Lower-case: " + String.join(", ", lowerCaseWords));
        System.out.println("Mixed-case: " + String.join(", ", mixedCaseWords));
        System.out.println("Upper-case: " + String.join(", ", upperCaseWords));
    }
}
