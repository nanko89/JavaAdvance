package Exersice;

import java.io.*;


public class P04CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads" +
                "\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        int countVowels = 0;
        int countConsonants = 0;
        int countPunctuation = 0;
        BufferedReader reader = new BufferedReader(new FileReader(path));
        PrintWriter writer = new PrintWriter("cont-characters.txt");
        String line = reader.readLine();
        String vowel = "aeoui";
        String punctuation = "!,.?";
        while (line != null){
        String[] words = line.split("\\s+");
            for (String word : words) {
                for (char symbol : word.toCharArray()) {
                   if (vowel.contains(String.valueOf(symbol))){
                        countVowels++;
                    }else if (punctuation.contains(String.valueOf(symbol))){
                       countPunctuation++;
                   }else {
                       countConsonants++;
                   }
                }
            }
            line = reader.readLine();
        }
        reader.close();
        writer.println("Vowels: " + countVowels);
        writer.println("Consonants: " + countConsonants);
        writer.println("Punctuation: " + countPunctuation);
        writer.close();
        }

    }

