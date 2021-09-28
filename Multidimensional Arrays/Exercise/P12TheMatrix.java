package Exercise;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P12TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        char[][] matrix = new char[rows][cols];
        fillMatrix(matrix, scanner);

        char fillChar = scanner.nextLine().charAt(0);

        input = scanner.nextLine().split("\\s+");

        int startRow = Integer.parseInt(input[0]);
        int startCol = Integer.parseInt(input[1]);

        char startChar = matrix[startRow][startCol];

        fill(matrix, startRow, startCol, fillChar, startChar);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                    System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void fill(char[][] matrix, int row, int col, char fillChar, char startChar) {
        if (matrix[row][col] != startChar){
            return;
        }
        matrix[row][col] = fillChar;

        if (row + 1 < matrix.length) {
            fill(matrix, row + 1, col, fillChar, startChar);
        }

        if (row - 1 >= 0) {
            fill(matrix, row - 1, col, fillChar, startChar);
        }

        if (col + 1 < matrix[row].length) {
            fill(matrix, row, col + 1, fillChar, startChar);
        }

        if (col - 1 >= 0) {
            fill(matrix, row, col - 1, fillChar, startChar);
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }

        }
    }
}
