import java.util.Arrays;
import java.util.Scanner;

public class P06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split(" ")).
                            mapToInt(Integer::parseInt).toArray();

            matrix[i] = row;

        }

        int[] first = new int[n];
        int[] second = new int[n];

        for (int row = 0; row < n; row++) {
                first[row] = matrix[row][row];
                second[row] = matrix[n - 1 - row][row];
        }

        System.out.println(Arrays.toString(first).replaceAll("[\\[\\],]",""));
        System.out.println(Arrays.toString(second).replaceAll("[\\[\\],]",""));
    }
}
