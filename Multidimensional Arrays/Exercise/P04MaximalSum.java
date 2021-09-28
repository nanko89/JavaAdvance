package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input  = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        readMatrix(matrix, scanner);
        int bestSum = Integer.MIN_VALUE;
        int[][] bestMatrix = new int[3][3];
        for (int row = 0; row <= rows - 3; row++) {
            for (int col = 0; col <= cols - 3; col++) {

                int[][] currentMatrix = findMatrix3X3(matrix, row, col);
                int sumMatrix = sumMatrix(currentMatrix);
                if (sumMatrix > bestSum){
                    bestSum = sumMatrix;
                    bestMatrix = findMatrix3X3(matrix,row,col);

                }

            }

        }
        System.out.println("Sum = " + bestSum);
        printMatrix(bestMatrix);

    }

    private static void printMatrix(int[][] bestMatrix) {

        for (int i = 0; i < bestMatrix.length; i++) {
            for (int j = 0; j < bestMatrix[i].length; j++) {
                System.out.print(bestMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int sumMatrix(int[][] newMatrix) {
        int sum = 0;
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                sum += newMatrix[row][col];
            }
        }
        return sum;
    }

    private static int[][] findMatrix3X3(int[][] matrix, int row, int col) {

        int[][] findingMatrix = new int[3][3];

        for (int i = 0; i < 3 ; i++) {
            for (int j = 0; j < 3; j++) {
                findingMatrix[i][j] = matrix[row + i][col + j];
            }
        }
        return findingMatrix;
    }

    public static void readMatrix (int[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}
