package LinearDataStructuresExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int degree = Integer.parseInt(scanner.nextLine().split("[()]+")[1]) % 360;
        List<String> words = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            words.add(input);
            input = scanner.nextLine();
        }
        int rows = words.size();
        int cols = words.stream().mapToInt(String::length).max().orElse(0);

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < words.get(row).length()) {
                    matrix[row][col] = words.get(row).charAt(col);
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }
        if (degree == 270) {
            printMatrix270(matrix, rows, cols);
        } else if (degree == 180) {
            printMatrix180(matrix, rows, cols);
        } else if (degree == 90) {
            printMatrix90(matrix, rows, cols);
        } else {
            printMatrix(matrix);
        }
    }

    private static void printMatrix270(char[][] matrix, int rows, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180(char[][] matrix, int rows, int cols) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90(char[][] matrix, int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >= 0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


}
