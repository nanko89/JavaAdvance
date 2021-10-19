package Exam16December2020;

import com.sun.jdi.Value;

import java.util.Scanner;

public class P02Selling {
    public static int rowPosition = 0;
    public static int colPosition = 0;
    public static int[] firstPillars = new int[2];
    public static int[] secondPillars = new int[2];
    public static int money = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        boolean haveFirstPill = false;
        boolean outBounds = false;
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < line.length(); j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'S') {
                    rowPosition = i;
                    colPosition = j;
                    matrix[rowPosition][colPosition] = '-';
                }
                if (matrix[i][j] == 'O') {
                    if (!haveFirstPill) {
                        firstPillars[0] = i;
                        firstPillars[1] = j;
                        haveFirstPill = true;
                    } else {
                        secondPillars[0] = i;
                        secondPillars[1] = j;
                    }
                }
            }
        }
        while (!outBounds && money < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    outBounds = movePosition(matrix, -1, 0);
                    break;
                case "down":
                    outBounds = movePosition(matrix, +1, 0);
                    break;
                case "left":
                    outBounds = movePosition(matrix, 0, -1);
                    break;
                case "right":
                    outBounds = movePosition(matrix, 0, +1);
                    break;
            }
            if (money >= 50){
                break;
            }

        }

        if (outBounds) {
            System.out.println("Bad news, you are out of the Exam16December2020.bakery.");
        } else {
            System.out.println("Good news! You succeeded in collecting enough money!");
            matrix[rowPosition][colPosition] = 'S';
        }
        System.out.println("Money: " + money);

        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean movePosition(char[][] matrix, int row, int col) {
        int newRow = row + rowPosition;
        int newCol = col + colPosition;
        if (checkPosition(matrix, newRow, newCol)) {
            char current = matrix[newRow][newCol];
            rowPosition = newRow;
            colPosition = newCol;
            matrix[rowPosition][colPosition] = '-';
            if (Character.isDigit(current )) {
                money += Integer.parseInt(String.valueOf(current));
            } else if (current == 'O') {
                if (rowPosition == firstPillars[0] && colPosition == firstPillars[1]) {
                    rowPosition = secondPillars[0];
                    colPosition = secondPillars[1];
                    matrix[rowPosition][colPosition] = '-';
                }
            }
            return false;
        }
        return true;
    }

    private static boolean checkPosition(char[][] matrix, int rows, int cols) {
        return rows >= 0 && rows < matrix.length
                && cols >= 0 && cols < matrix.length;
    }
}
