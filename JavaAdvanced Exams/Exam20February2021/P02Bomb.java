package Exam20February2021;

import java.util.Scanner;

public class P02Bomb {
    public static int rowPosition = 0;
    public static int colPosition = 0;
    public static int bomb = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(",");
        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < line.length; j++) {
                matrix[i][j] = line[j].charAt(0);
                if (matrix[i][j] == 's') {
                    rowPosition = i;
                    colPosition = j;
                    matrix[rowPosition][colPosition] = '+';
                }
                if (matrix[i][j] == 'B') {
                    bomb++;
                }
            }
        }

        boolean findEnd = false;
        int index = -1;
        while (++index < command.length && !findEnd) {
            switch (command[index]) {
                case "up":
                    findEnd = movePosition(matrix, -1, 0);
                    break;
                case "down":
                    findEnd = movePosition(matrix, +1, 0);
                    break;
                case "left":
                    findEnd = movePosition(matrix, 0, -1);
                    break;
                case "right":
                    findEnd = movePosition(matrix, 0, +1);
                    break;
            }
        }
        if (bomb == 0){
            System.out.println("Congratulations! You found all bombs!");
        }else if (findEnd){
            System.out.printf("END! %d bombs left on the field", bomb);
        }else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bomb, rowPosition,colPosition);
        }

    }

    private static boolean movePosition(char[][] matrix, int row, int col) {
        rowPosition = rowPosition + row;
        colPosition = colPosition + col;
        checkIndex(matrix);

        char current = matrix[rowPosition][colPosition];
        matrix[rowPosition][colPosition] = '+';
        if (current == 'B') {
            System.out.println("You found a bomb!");
            bomb--;
        } else if (current == 'e') {
            return true;
        }
        return false;
    }

    private static void checkIndex(char[][] matrix) {
        if (colPosition >= matrix.length){
            colPosition = matrix.length -1;
        }

        if (colPosition < 0){
            colPosition = 0;
        }

        if (rowPosition >= matrix.length){
            rowPosition = matrix.length -1;
        }

        if (rowPosition < 0){
            rowPosition = 0;
        }
    }
}
