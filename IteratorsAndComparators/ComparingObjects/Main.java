package ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("END")){
            String[] data  = input.split(" ");
            Person person = new Person(data[0], Integer.parseInt(data[1]), data[2]);
            people.add(person);
            input = scanner.nextLine();
        }
        int n = Integer.parseInt(scanner.nextLine());
        Person searchPerson = people.get(n - 1);

        int equalPeople = 0;

        for (Person person : people) {
            if (searchPerson.compareTo(person) == 0){
                equalPeople ++;
            }
        }

        if (equalPeople == 1){
            System.out.println("No matches");
        }else {
            System.out.println(equalPeople + " " + (people.size()  - equalPeople) + " " + people.size());
        }
    }
}
