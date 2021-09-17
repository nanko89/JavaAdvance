package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class P01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input= scanner.nextLine();

        Set<String> carsNumber = new LinkedHashSet<>();
        while (!input.equals("END")){
            String command = input.split(", ")[0];
            String number = input.split(", ")[1];

            if (command.equals("IN")){
                carsNumber.add(number);
            }else {
                carsNumber.remove(number);
            }

            input = scanner.nextLine();

        }

        String output;

        if (carsNumber.isEmpty()){
            output = "Parking Lot is Empty";
        }else {
            output = carsNumber
                    .stream()
                    .collect(Collectors.joining(System.lineSeparator()));
        }
        System.out.println(output);
    }
}
