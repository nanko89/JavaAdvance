package Exam26June2021;

import java.util.Scanner;

public class P02Python {
    public static int startRow = 0;
    public static int startCol = 0;
    public static int lengthPython = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[] command = scanner.nextLine().split("[, ]+");

        char[][] matrix = new char[size][size];

        int totalFood = 0;

        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split(" ");
            for (int col = 0; col < line.length; col++) {
                matrix[row][col] = line[col].charAt(0);

                if (matrix[row][col] == 's') {
                    startRow = row;
                    startCol = col;
                    matrix[row][col] = '*';
                }

                if (matrix[row][col] == 'f') {
                    totalFood++;
                }
            }
        }

        boolean isHaveEnemy = false;

        int index = -1;
        while (++index < command.length && !isHaveEnemy) {
            switch (command[index]) {
                case "up":
                    isHaveEnemy = movePosition(matrix, -1 + startRow, startCol);
                    break;
                case "down":
                    isHaveEnemy = movePosition(matrix, 1 + startRow, startCol);
                    break;
                case "left":
                    isHaveEnemy = movePosition(matrix, startRow, startCol - 1);
                    break;
                case "right":
                    isHaveEnemy = movePosition(matrix, startRow, startCol + 1);
                    break;
            }
        }
        if (lengthPython > totalFood){
            System.out.println("You win! Final python length is " + lengthPython);
        }else if (isHaveEnemy){
            System.out.println("You lose! Killed by an enemy!");
        }else {
            System.out.printf("You lose! There is still %d food to be eaten.",totalFood + 1 - lengthPython);
        }
    }

    private static boolean movePosition(char[][] matrix, int row, int col) {
        startRow = row;
        startCol = col;
        isValidIndex(matrix, row, col);
        if (matrix[startRow][startCol] == 'f') {
            lengthPython++;
            matrix[startRow][startCol] = '*';
        } else if (matrix[startRow][startCol] == 'e') {
            return true;
        }

        return false;
    }

    private static void isValidIndex(char[][] matrix, int row, int col) {
        if (row < 0) {
            startRow = matrix.length - 1;
        }
        if (col < 0) {
            startCol = matrix.length - 1;
        }

        if (col == matrix.length) {
            startCol = 0;
        }

        if (row == matrix.length) {
            startRow = 0;
        }
    }
}
