package Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(numbers);
        int divider = Integer.parseInt(scanner.nextLine());
        numbers.stream().mapToInt(i->i).filter(e -> e % divider != 0 ).forEach(e -> System.out.print(e + " "));
    }
}
