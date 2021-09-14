package Exercise;

import java.util.Scanner;

public class P02MatrixPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        String[][] matrix = new String[rows][cols];
        StringBuilder word = new StringBuilder();
        int number = 0;
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {
                char first = (char) (97 + row );
                char second = (char) (97 + col + number);
                char third = (char) (97 + row);
                word.append(first).append(second).append(third);
                matrix[row][col] = word.toString();
                word.setLength(0);
            }
            number++;
        }
      printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
