package LabLinearDataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] element = scanner.nextLine().split(", ");
        int row = Integer.parseInt(element[0]);
        int col = Integer.parseInt(element[1]);
        int maxSum = 0;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int[][] newMatrix = new int[2][2];
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < col - 1; j++) {
                int sum = matrix[i][j] + matrix[i + 1][j]
                        + matrix[i][j + 1] + matrix[i + 1][j + 1];
                if (sum > maxSum) {
                    maxSum = sum;
                    newMatrix[0][0] = matrix[i][j];
                    newMatrix[0][1] = matrix[i][j + 1];
                    newMatrix[1][0] = matrix[i + 1][j];
                    newMatrix[1][1] = matrix[i + 1][j + 1];
                }

            }
        }
        System.out.println(newMatrix[0][0] + " " + newMatrix[0][1]);
        System.out.println(newMatrix[1][0] + " " + newMatrix[1][1]);
        System.out.println(maxSum);

    }
}

