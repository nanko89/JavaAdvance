package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class P10RadioactiveMutantVampireBunnies {
    public static boolean isPlayerDead = false;
    public static int[] playerPosition = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        scanner.nextLine();
        ArrayDeque<Integer> bunnyPosition = new ArrayDeque<>();
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = arr[col].charAt(0);
                if (matrix[row][col] == 'B') {
                    bunnyPosition.offer(row);
                    bunnyPosition.offer(col);
                }
                if (matrix[row][col] == 'P') {
                    playerPosition[0] = row;
                    playerPosition[1] = col;
                    matrix[row][col] = '.';
                }
            }
        }


        String move = scanner.nextLine();
        int counter = -1 ;
        while (++counter < move.length() && !isPlayerDead) {

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            char currentMove = move.charAt(counter);
            switch (currentMove) {
                case 'U':
                    playerRow = playerRow - 1;
                    break;
                case 'D':
                    playerRow = playerRow + 1;
                    break;
                case 'L':
                    playerCol = playerCol - 1;
                    break;
                case 'R':
                    playerCol = playerCol + 1;
                    break;
            }

            if (!isValid(playerRow, playerCol, matrix)) {
                break;
            }
            playerPosition[0] = playerRow;
            playerPosition[1] = playerCol;

            if (!isFree(playerCol, playerRow, matrix)) {
                isPlayerDead = true;
                break;
            }

            moveBunnys(matrix, bunnyPosition);
            if (matrix[playerRow][playerCol] == 'B'){
                printMatrix(matrix);
                System.out.print("dead: ");
                System.out.println(playerPosition[0] + " " + playerPosition[1]);
               return;
            }
        }
        moveBunnys(matrix, bunnyPosition);
        printMatrix(matrix);
        if (isPlayerDead) {
            System.out.print("dead: ");
        } else {
            System.out.print("won: ");
        }
        System.out.println(playerPosition[0] + " " + playerPosition[1]);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                char symbol = matrix[row][col];
                System.out.print(symbol);
            }
            System.out.println();
        }
    }

    private static void moveBunnys(char[][] matrix, ArrayDeque<Integer> bunnyPosition) {
        int length = bunnyPosition.size() / 2;
        for (int i = 0; i < length; i++) {
            int row = bunnyPosition.poll();
            int col = bunnyPosition.poll();

            if (isValid(row, col + 1 ,matrix) && haveBunny(row, col + 1, matrix)) {
                matrix[row][col + 1] = 'B';
                bunnyPosition.offer(row);
                bunnyPosition.offer(col + 1);
            }
            if (isValid(row, col - 1,  matrix) && haveBunny(row, col - 1, matrix)) {
                matrix[row][col - 1] = 'B';
                bunnyPosition.offer(row);
                bunnyPosition.offer(col - 1);
            }
            if (isValid( row + 1,col, matrix) && haveBunny(row + 1, col, matrix)) {
                matrix[row + 1][col] = 'B';
                bunnyPosition.offer(row + 1);
                bunnyPosition.offer(col);
            }
            if (isValid(row - 1,col, matrix) && haveBunny(row - 1, col, matrix)) {
                matrix[row -1][col] = 'B';
                bunnyPosition.offer(row - 1);
                bunnyPosition.offer(col);
            }
        }
    }

    private static boolean isFree(int playerCol, int playerRow, char[][] matrix) {
        return matrix[playerRow][playerCol] == '.';
    }

    private static boolean isValid(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static boolean haveBunny(int row, int col, char[][] matrix) {

        return matrix[row][col] != 'B';
    }
}


