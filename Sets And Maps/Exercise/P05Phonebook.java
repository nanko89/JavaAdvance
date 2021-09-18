package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new LinkedHashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("search")){
            String name = input.split("-")[0];
            String number = input.split("-")[1];
            phonebook.put(name,number);
            input = scanner.nextLine();

        }

        input = scanner.nextLine();

        while (!input.equals("stop")){
            String name = input;
            if (phonebook.containsKey(name)){
                System.out.println(name + " -> " + phonebook.get(name));
            }else {
                System.out.printf("Contact %s does not exist.%n", name);
            }
            input = scanner.nextLine();

        }

    }
}
