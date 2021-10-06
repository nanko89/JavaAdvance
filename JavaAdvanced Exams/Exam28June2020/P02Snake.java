package Exam28June2020;

import java.util.Scanner;

public class P02Snake {
    public static int snakeRow = 0;
    public static int snakeCol = 0;
    public static int food = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstBurrow = new int[2];
        int[] secondBurrow = new int[2];

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];
        boolean findFirstBurrow = false;
        boolean validIndex = true;
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'S') {
                    snakeRow = row;
                    snakeCol = col;
                    matrix[row][col] = '.';
                }
                if (matrix[row][col] == 'B') {
                    if (!findFirstBurrow) {
                        firstBurrow[0] = row;
                        firstBurrow[1] = col;
                        findFirstBurrow = true;
                    } else {
                        secondBurrow[0] = row;
                        secondBurrow[1] = col;

                    }
                }
            }


        }

            while (validIndex && food < 10) {
             String command = scanner.nextLine();
                switch (command) {
                    case "up":
                        validIndex = checkPosition(matrix, firstBurrow, secondBurrow, -1, 0);
                        break;
                    case "down":
                        validIndex = checkPosition(matrix, firstBurrow, secondBurrow, +1, 0);
                        break;
                    case "left":
                        validIndex = checkPosition(matrix, firstBurrow, secondBurrow, 0, -1);
                        break;
                    case "right":
                        validIndex = checkPosition(matrix, firstBurrow, secondBurrow, 0, +1);
                        break;
                }
                if (food == 10){
                    break;
                }


            }
        if (!validIndex){
            System.out.println("Game over!");
        }else if (food >= 10){
            System.out.println("You won! You fed the snake.");
            matrix[snakeRow][snakeCol] = 'S';
        }
        System.out.printf("Food eaten: %d%n", food);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    private static boolean checkPosition(char[][] matrix, int[] firstBurrow, int[] secondBurrow, int row, int col) {
        if (isValidIndex(matrix, row, col)) {
            snakeRow = snakeRow + row;
            snakeCol = snakeCol + col;
            char current = matrix[snakeRow][snakeCol];

            if (current == '*') {
                food++;
             matrix[snakeRow][snakeCol] = '.';
            } else if (current == 'B') {
                if (snakeRow == firstBurrow[0] && snakeCol == firstBurrow[1]) {
                    matrix[snakeRow ][snakeCol ] = '.';
                    snakeRow = secondBurrow[0];
                    snakeCol = secondBurrow[1];
                    matrix[snakeRow][snakeCol] = '.';
                } else {
                    matrix[snakeRow][snakeCol] = '.';
                    snakeRow = firstBurrow[0];
                    snakeCol = firstBurrow[1];
                    matrix[snakeRow][snakeCol] = '.';
                }
            }else {
                matrix[snakeRow][snakeCol] = '.';
            }
            return true;
        }
        return false;
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
        int currentRow = row + snakeRow;
        int currentCol = col + snakeCol;
        return currentRow >= 0 && currentRow < matrix.length && currentCol >= 0 && currentCol < matrix.length;
    }
}
