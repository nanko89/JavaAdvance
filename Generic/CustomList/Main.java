package CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomList<String> list = new CustomList<String>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];
            switch (command) {
                case "Add":
                    String elementAdd = tokens[1];
                    list.add(elementAdd);
                    break;
                case "Remove":
                    int indexRemove = Integer.parseInt(tokens[1]);
                    list.remove(indexRemove);
                    break;
                case "Contains":
                    String elementContains = tokens[1];
                    System.out.println(list.contains(elementContains));
                    break;
                case "Swap":
                    int indexFirst = Integer.parseInt(tokens[1]);
                    int indexSecond = Integer.parseInt(tokens[2]);
                    list.swap(indexFirst, indexSecond);
                    break;
                case "Greater":
                    String elementGreater = tokens[1];
                    System.out.println(list.countGreaterThan(elementGreater));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    for (String s : list) {
                        System.out.println(s);
                    }
                    break;
            }

            input = scanner.nextLine();

        }

    }
}
