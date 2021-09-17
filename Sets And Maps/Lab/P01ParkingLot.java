package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01ParkingLot {
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
        if (carsNumber.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            carsNumber.forEach(System.out::println);
        }


    }
}
