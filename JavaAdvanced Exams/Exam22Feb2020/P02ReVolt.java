package Exam22Feb2020;

import java.util.Scanner;

public class P02ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int linesCount = Integer.parseInt(scanner.nextLine());
        int[] position = new int[2];
        char[][] matrix = new char[size][size];

        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("f")) {
                position[0] = row;
                position[1] = line.indexOf("f");
            }
        }
        boolean playerWon = false;
        while (linesCount-- > 0 && !playerWon) {

            String command = scanner.nextLine();
            if (command.equals("up")) {
                playerWon = movePlayer(position, matrix, -1,0);
            } else if (command.equals("down")) {
                playerWon = movePlayer(position, matrix, +1,0);
            } else if (command.equals("left")) {
                playerWon = movePlayer(position, matrix, 0,-1);
            } else if (command.equals("right")) {
                playerWon = movePlayer(position, matrix, 0,+1);
            }


        }

        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }
        printMatrix(matrix);
    }

    private static boolean movePlayer(int[] position, char[][] matrix, int rowModificator, int colModificator) {
        int row = position[0];
        int col = position[1];
        int newRow = ensureIndexOutBounds( row + rowModificator, matrix.length);
        int newCol = ensureIndexOutBounds(col + colModificator, matrix.length);
        boolean hasWon = false;
        if (matrix[newRow][newCol] == 'B'){
            newRow = ensureIndexOutBounds(newRow + rowModificator, matrix.length);
            newCol = ensureIndexOutBounds(newCol + colModificator, matrix.length);

        }else if (matrix[newRow][newCol] == 'T'){
            newRow = row;
            newCol = col;
        }
        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        }
        matrix[row][col] = '-';
        matrix[newRow][newCol] = 'f';
        position[0] = newRow;
        position[1] = newCol;

        return hasWon;
    }

    private static int ensureIndexOutBounds(int index , int bounds) {
        if (index < 0){
                index = bounds - 1;
        }else if (index >= bounds){
            index = 0;
        }
        return index;
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
