package ExerciseP01OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();
        while (n-- > 0){
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age= Integer.parseInt(input[1]);
            if (age > 30) {
                Person person = new Person(name, age);
                personList.add(person);
            }
        }
        personList.sort(Comparator.comparing(Person::getName));
        for (Person person : personList) {
            System.out.println(person.toString());
        }
    }
}
