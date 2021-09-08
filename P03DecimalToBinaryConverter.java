import java.util.ArrayDeque;
import java.util.Scanner;

public class P03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque <Integer> binary = new ArrayDeque<>();
        if (n == 0){
            System.out.println(0);
        }else {
            while (n != 0) {
                int result = n % 2;
                binary.push(result);
                n = n / 2;
            }
            while (binary.size() > 0) {
                System.out.print(binary.poll());
            }
        }

    }
}
