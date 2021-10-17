package LinearDataStructuresExercises;

import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       String input = scanner.nextLine();
       int rows = Integer.parseInt(input.split(" ")[0]);
       int cols = Integer.parseInt(input.split(" ")[1]);
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                StringBuilder word = new StringBuilder();
                char first = (char) ('a' + row);
                char second = (char) ('a' + col + row);
                word.append(first).append(second).append(first);
                matrix[row][col] = word.toString();
            }
        }
        printMatrix(matrix,rows,cols);

    }

    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i <rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
