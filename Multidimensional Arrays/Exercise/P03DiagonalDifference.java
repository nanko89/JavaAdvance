package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        readMatrix(matrix, scanner);

        int primaryDiagonal = findPrimaryDiagonal(matrix);
        int secondaryDiagonal = findSecondaryDiagonal(matrix);

        System.out.println(Math.abs(primaryDiagonal - secondaryDiagonal));


    }

    private static int findSecondaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][matrix.length - 1 - i];
        }
        return sum;
    }

    private static int findPrimaryDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static void readMatrix (int[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).
                            mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}
