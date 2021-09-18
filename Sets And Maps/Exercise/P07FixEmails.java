package Exersice;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String,String> info = new LinkedHashMap<>();
        while (!input.equals("stop")){
            String name = input;
            String email = scanner.nextLine();

            if (!email.contains(".uk") && !email.contains(".com") && !email.contains(".us")){
                info.put(name,email);
            }

            input = scanner.nextLine();

        }
        info.forEach((k,v) -> System.out.println(k + " -> " + v));
    }
}
