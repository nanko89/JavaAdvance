
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P03CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        Predicate<String> check = w -> w.charAt(0) >= 65 && w.charAt(0) <= 90;

        List<String> words = Arrays.stream(input).filter(check)
                .collect(Collectors.toList());

        System.out.println(words.size());
        words.forEach(System.out::println);

    }
}
