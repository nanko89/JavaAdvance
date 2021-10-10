package StackIterator;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Stack<Integer> stack = new Stack<>();
        String command = scanner.nextLine();
        boolean isEmpty = false;
        while (!command.equals("END")) {
            String[] token = command.split("[, ]+");
            switch (token[0]) {
                case "Pop":
                    try {
                        stack.pop();
                    } catch (Exception e) {
                        System.out.println("No elements");
                        isEmpty = true;
                    }
                    break;
                case "Push":

                    for (int i = 1; i < token.length; i++) {
                        stack.push(Integer.parseInt(token[i]));
                    }
                    break;
            }


            command = scanner.nextLine();

        }
        if (!isEmpty) {
            for (int i = 1; i <= 2; i++) {
                for (Integer integer : stack) {
                    System.out.println(integer);
                }
            }
        }

    }
}
