package LinearDataStructuresExercises;

import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        int rows = Integer.parseInt(data.split(" ")[0]);
        int cols = Integer.parseInt(data.split(" ")[1]);

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix,scanner);
        int maxSum = 0;
        int[][] newMatrix = new int[3][3];
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
               int currnetSum = findSum(matrix,row,col);
               if (currnetSum > maxSum){
                   maxSum = currnetSum;
                   newMatrix = fillNewMatrix(matrix,row,col);

               }
            }
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(newMatrix);
    }

    private static void printMatrix(int[][] newMatrix) {
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillNewMatrix(int[][] matrix, int row, int col) {
        int[][] newMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newMatrix[i][j] = matrix[i + row][j + col];
            }
        }
        return newMatrix;
    }

    private static int findSum(int[][] matrix, int row, int col) {
        int sum = 0;
        int[][] newMatrix = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                newMatrix[i][j] = matrix[i + row][j + col];
                sum += newMatrix[i][j];
            }
        }
        return sum;
    }

    private static void fillMatrix(int[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row]= line;
        }
    }
}
