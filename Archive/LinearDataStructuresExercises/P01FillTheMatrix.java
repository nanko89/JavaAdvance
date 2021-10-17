package LinearDataStructuresExercises;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String type = input[1];
        int[][] matrix = new int[n][n];
        int number = 1;
        if (type.equals("A")) {
            for (int col = 0; col < n; col++) {
                for (int row = 0; row < n; row++) {
                    matrix[row][col] = number++;
                }
            }
        } else {
            for (int col = 0; col < n; col++) {
                if (col % 2 == 0) {
                    for (int row = 0; row < n; row++) {
                        matrix[row][col] = number++;
                    }
                } else {
                    for (int row = n - 1; row >= 0; row--) {
                        matrix[row][col] = number++;
                    }
                }
            }
        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
