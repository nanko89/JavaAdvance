import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class P01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] number = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int[] sorted = Arrays.stream(number).filter(e -> e % 2 == 0).toArray();
        String num =  Arrays.stream(sorted).mapToObj(String::valueOf).collect(Collectors.joining(", "));
        String sortedNum = Arrays.stream(sorted).sorted().mapToObj(String::valueOf).collect(Collectors.joining(", "));

        System.out.println(num);
        System.out.println(sortedNum);
    }
}
