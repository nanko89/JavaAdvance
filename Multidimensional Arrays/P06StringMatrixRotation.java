package Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P06StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int degree = Integer.parseInt(input.substring(7,input.length() - 1)) % 360;
        String word = scanner.nextLine();
        List<String> words = new ArrayList<>();

        while (!word.equals("END")){
                words.add(word);
            word = scanner.nextLine();
        }
        int rows = words.size();
        int cols = findMaxLengthWord(words);

        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col < words.get(row).length()){
                    matrix[row][col] = words.get(row).charAt(col);
                }else {
                    matrix[row][col] = ' ';
                }
            }
        }

        if (degree == 270) {
            printMatrix270Rotation(matrix,cols,rows);
        }else if (degree == 180){
            printMatrix180Rotation(matrix,cols,rows);
        }else if (degree == 90){
            printMatrix90Rotation(matrix, cols, rows);
        }else {
            printMatrix(matrix);
        }

    }

    private static void printMatrix270Rotation(char[][] matrix, int cols, int rows) {

        for (int col = cols - 1; col >= 0 ; col--) {
            for (int row = 0; row  < rows ; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix180Rotation(char[][] matrix, int cols, int rows) {

        for (int row = rows - 1; row >= 0 ; row--) {
            for (int col = cols - 1; col >= 0  ; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix90Rotation(char[][] matrix, int cols, int rows) {
        for (int col = 0; col < cols ; col++) {
            for (int row = rows - 1; row  >= 0 ; row--) {
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

    private static int findMaxLengthWord(List<String> words) {
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < words.size(); i++) {
            int size = words.get(i).length();
            if (size > maxLength) {
                maxLength = size;
            }
        }
        return maxLength;
    }
}
