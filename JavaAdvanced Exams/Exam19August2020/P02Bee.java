package Exam19August2020;

import java.util.Scanner;

public class P02Bee {
    public static int beeRow = 0;
    public static int beeCol = 0;
    public static int flower = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < size; col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'B') {
                    beeRow = row;
                    beeCol = col;
                    matrix[row][col] = '.';
                }
            }
        }
        boolean validIndex = true;

        String command = scanner.nextLine();

        while (!command.equals("End") && validIndex) {
            switch (command) {
                case "up":
                    validIndex = checkPosition(matrix, -1, 0);
                    break;
                case "down":
                    validIndex = checkPosition(matrix, +1, 0);
                    break;
                case "left":
                    validIndex = checkPosition(matrix, 0, -1);
                    break;
                case "right":
                    validIndex = checkPosition(matrix, 0, +1);
                    break;
            }
            if (!validIndex){
                break;
            }
            command = scanner.nextLine();
        }

        if (!validIndex) {
            System.out.println("The bee got lost!");
        }else {
            matrix[beeRow][beeCol] = 'B';
        }
        if (flower < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flower);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flower);
        }
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

    private static boolean checkPosition(char[][] matrix, int row, int col) {
        if (isValidIndex(matrix, row + beeRow, col + beeCol)) {
            beeRow = beeRow + row;
            beeCol = beeCol + col;
            char current = matrix[beeRow][beeCol];

            if (current == 'f') {
                flower++;
                matrix[beeRow][beeCol] = '.';
            } else if (current == 'O') {
                matrix[beeRow][beeCol] = '.';
                checkPosition(matrix, row, col);
            } else {
                matrix[beeRow][beeCol] = '.';
            }
            return true;
        }
        return false;
    }

    private static boolean isValidIndex(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length
                && col >= 0 && col < matrix.length;
    }


}

