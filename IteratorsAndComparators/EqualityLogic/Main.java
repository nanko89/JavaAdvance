package EqualityLogic;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Person> peopleTreeSet = new TreeSet<>(new ComparatorPerson());
        Set<Person> peopleHashset = new HashSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            Person person = new Person(data[0], Integer.parseInt(data[1]));
            peopleTreeSet.add(person);
            if (!peopleHashset.contains(person)) {
                peopleHashset.add(person);
            }

        }
        System.out.println(peopleTreeSet.size());
        System.out.println(peopleHashset.size());
    }
}
