package Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class P11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        readMatrix(matrix,scanner);

        int row = rows - 1;
        int col = cols - 1;

        while (row != -1) {
            int c = col;
            int r = row;
            while (c < cols && r >= 0) {
                System.out.print(matrix[r--][c++] + " ");
            }
            System.out.println();
            col--;

            if (col == -1) {
                col = 0;
                row--;
            }
        }

    }
    public static void readMatrix (int[][] matrix, Scanner scanner){
        for (int row = 0; row < matrix.length; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();
            matrix[row] = arr;
        }
    }
}

