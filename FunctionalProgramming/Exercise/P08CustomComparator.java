package Exercise;

import java.util.*;

import java.util.stream.Collectors;

public class P08CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> comparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0) {
                return -1;
            } else if (first % 2 != 0 && second % 2 == 0) {
                return 1;
            } else if ((first % 2 == 0 && second % 2 == 0) ) {
                first.compareTo(second);
            }
            return  first.compareTo(second);
        };

        numbers.sort(comparator);
        numbers.forEach(e -> System.out.print(e + " "));
    }
}


