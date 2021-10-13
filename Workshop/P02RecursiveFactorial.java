import java.util.Scanner;

public class P02RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        long num = factorial(n);
        System.out.println(num);
    }
        static long factorial(int num) {
            if (num == 0) {
                return 1;
            }
            return num * factorial(num - 1);
        }


    }

