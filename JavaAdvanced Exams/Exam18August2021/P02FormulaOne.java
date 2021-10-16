package Exam18August2021;

import java.io.BufferedReader;
import java.io.InputStreamReader;


public class P02FormulaOne {
    public static int playerRow = 0;
    public static int playerCol = 0;
    public static int[] lastPosition = new int[2];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int countCommands = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = reader.readLine();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = line.charAt(j);
                if (matrix[i][j] == 'P') {
                    playerRow = i;
                    playerCol = j;
                    matrix[playerRow][playerCol] = '.';
                    lastPosition[0] = i;
                    lastPosition[1] = j;
                }
            }
        }

        boolean findFinish = false;

        while (countCommands-- > 0 && !findFinish) {
            String command = reader.readLine();
            switch (command) {
                case "up":
                    findFinish = movePosition(matrix, -1, 0);
                    break;
                case "down":
                    findFinish = movePosition(matrix, +1, 0);
                    break;
                case "left":
                    findFinish = movePosition(matrix, 0, -1);
                    break;
                case "right":
                    findFinish = movePosition(matrix, 0, +1);
                    break;
            }
        }
        matrix[playerRow][playerCol] = 'P';
        if (findFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static boolean movePosition(char[][] matrix, int row, int col) {
        lastPosition[0] = playerRow;
        lastPosition[1] = playerCol;
        playerRow = playerRow + row;
        playerCol = playerCol + col;
        isValidIndex(matrix);

        if (matrix[playerRow][playerCol] == 'F') {
            return true;
        } else if (matrix[playerRow][playerCol] == 'B') {
            movePosition(matrix, row, col);
        } else if (matrix[playerRow][playerCol] == 'T') {
            playerRow = lastPosition[0];
            playerCol = lastPosition[1];
        }

        return false;
    }

    private static void isValidIndex(char[][] matrix) {
        if (playerCol < 0) {
            playerCol = matrix.length - 1;
        }
        if (playerRow < 0) {
            playerRow = matrix.length - 1;
        }
        if (playerCol == matrix.length) {
            playerCol = 0;
        }
        if (playerRow == matrix.length) {
            playerRow = 0;
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
