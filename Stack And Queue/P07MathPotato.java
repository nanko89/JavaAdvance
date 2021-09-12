import java.util.ArrayDeque;
import java.util.Scanner;

public class P07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> namesChild = new ArrayDeque<>();

        for (String child : children) {
            namesChild.offer(child);
        }
        int cycle = 1;
        while (namesChild.size() > 1) {
            for (int i = 1; i < n; i++) {
                namesChild.offer(namesChild.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + namesChild.peek());
            }else {
                System.out.println("Removed " + namesChild.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + namesChild.poll());
    }

    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        else if (n == 2)
            return true;

        else if (n % 2 == 0)
            return false;

        for (int i = 3; i <= Math.sqrt(n); i += 2)
        {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
