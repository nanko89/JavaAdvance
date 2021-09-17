package Lab;

import java.util.*;

public class P02SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> guests  = new TreeSet<>();

        String guest = scanner.nextLine();
        while (!guest.equals("PARTY")){
                guests.add(guest);

            guest = scanner.nextLine();
        }

        String arrive = scanner.nextLine();
        while (!arrive.equals("END")){
                guests.remove(arrive);

            arrive = scanner.nextLine();
        }
        System.out.println(guests.size());

        guests.forEach(System.out::println);

    }
}
