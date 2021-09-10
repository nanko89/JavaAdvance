import java.util.ArrayDeque;
import java.util.Scanner;

public class P01ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input  = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (String s : input) {
            numbers.push(Integer.valueOf(s));
        }
        while (numbers.size() > 1){
            System.out.print(numbers.pop() + " ");
        }
        System.out.println(numbers.pop());
    }
}
