package LinearDataStructuresExercises;


import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];

        fillMatrix(matrix,size,scanner);

        int maxSum = maxDiagonalSum(matrix);
        System.out.println(maxSum);

    }

    private static int maxDiagonalSum(int[][] matrix) {
        int primaryDiagonalSum = 0;
        for (int i = 0; i < matrix.length; i++) {
                primaryDiagonalSum += matrix[i][i];
        }
        int secondaryDiagonal = 0;

        for (int i = 0; i < matrix.length; i++) {
                secondaryDiagonal += matrix[i][matrix.length - 1 - i ];

        }

        return Math.abs(primaryDiagonalSum - secondaryDiagonal);
    }

    private static void fillMatrix(int[][] matrix, int size, Scanner scanner) {
        for (int i = 0; i < size; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = currentRow;
        }
    }

}
