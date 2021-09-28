package Exercise;

import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(input[0]);
        String pattern = input[1];

        int[][] matrix = new int[n][n];

        int number = 1;
        if (pattern.equals("A")) {
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    matrix[col][row] = number;
                    number++;
                }
            }
        } else {
            for (int row = 0; row < n; row++) {
                if(row % 2 == 0){
                for (int col = 0; col < n; col++) {
                    matrix[col][row] = number;
                    number++;
                }

                }else {
                    for (int col = n- 1; col >= 0; col--) {
                        matrix[col][row] = number;
                        number++;
                    }
                }
            }

        }
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

