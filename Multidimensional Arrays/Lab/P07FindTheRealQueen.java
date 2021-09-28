
import java.util.Scanner;

public class P07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = readMatrix(scanner);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char current = matrix[row][col];
                if (current == 'q') {
                    if (checkQueen(matrix, row, col)) {
                        System.out.println(row + " " + col);
                    }
                }
            }
        }


    }

    private static boolean checkQueen(char[][] matrix, int row, int col) {
        for (int rowCheck = 0; rowCheck < 8; rowCheck++) {
            char current = matrix[row][rowCheck];
            if (current == 'q' && rowCheck != col) {
                return false;
            }
        }

        for (int colCheck = 0; colCheck < 8; colCheck++) {
            char current = matrix[colCheck][col];
            if (current == 'q' && colCheck != row) {
                return false;
            }
        }
        int element = col;
        for (int leftUp = row - 1; leftUp >= 0; leftUp--) {
            element--;
            if (isValid(row, element)) {
                char current = matrix[leftUp][element];
                if (current == 'q') {
                    return false;
                }
            }
        }

        element = col;
        for (int leftDown = row + 1; leftDown < 8; leftDown++) {
            element--;
            if (isValid(row, element)) {
                char current = matrix[leftDown][element];
                if (current == 'q') {
                    return false;
                }
            }
        }

        element = col;
        for (int rightUp = row - 1; rightUp >= 0; rightUp--) {
            element++;
            if (isValid(row, element)) {
                char current = matrix[rightUp][element];
                if (current == 'q') {
                    return false;
                }
            }
        }

        element = col;
        for (int rightDown = row + 1; rightDown < 8; rightDown++) {
            element++;
            if (isValid(row, element)) {
                char current = matrix[rightDown][element];
                if (current == 'q') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    private static char[][] readMatrix(Scanner scanner) {


        char[][] matrix = new char[8][8];

        for (int row = 0; row < matrix.length; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < matrix.length; col++) {
                matrix[row][col] = input[col].charAt(0);
            }
        }
        return matrix;
    }

}
