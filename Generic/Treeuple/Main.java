package Treeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        Threeuple<String, String, String> tuple1 = new Threeuple<>(input[0] + " " + input[1], input[2], input[3]);
        System.out.println(tuple1);

        input =  scanner.nextLine().split(" ");
        boolean isDrunk = input[2].equals("drunk") ? true : false;
        Threeuple<String, Integer, Boolean> tuple2 = new Threeuple<>(input[0], Integer.parseInt(input[1]), isDrunk);
        System.out.println(tuple2);

        input =  scanner.nextLine().split(" ");
        Threeuple<String, Double, String> tuple3 = new Threeuple<>(input[0], Double.parseDouble(input[1]), input[2]);
        System.out.println(tuple3);
    }
}
