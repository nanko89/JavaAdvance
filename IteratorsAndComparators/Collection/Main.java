package Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split(" "))
                .skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split(" ");
            switch (token[0]) {
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    try {
                    listyIterator.print();
                    }catch (Exception e){
                        System.out.println("Invalid Operation!");
                    }
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
                case "PrintAll":
                    listyIterator.printAll();
                    break;
            }

            input = scanner.nextLine();

        }

    }
}
