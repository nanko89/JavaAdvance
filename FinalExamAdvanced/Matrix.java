import java.util.Scanner;

public class Matrix {
    public static int rowPosition;
    public static int colPosition;
    public static int[] pillarOne = new int[2];
    public static int[] pillarTwo = new int[2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean findPillar = false;
        int size = 0;
        char[][] matrix = new char[size][size];

        //read Matrix char[][]
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();

            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);

                if (matrix[row][col] == 'S') {
                    rowPosition = row;
                    colPosition = col;
                    matrix[row][col] = '-';
                }

                if (matrix[row][col] == 'P') {
                    if (!findPillar) {
                        pillarOne[0] = row;
                        pillarOne[1] = col;
                        findPillar = true;
                    } else {
                        pillarTwo[0] = row;
                        pillarTwo[1] = col;
                    }
                }
            }
        }

        //read Command

        String command = scanner.nextLine();
        boolean outOfBounds = false;
        switch (command) {
            case "up":
                outOfBounds = movePosition(matrix, -1, 0);
                break;
            case "down":
                outOfBounds = movePosition(matrix, +1, 0);
                break;
            case "left":
                outOfBounds = movePosition(matrix, 0, -1);
                break;
            case "right":
                outOfBounds = movePosition(matrix, 0, +1);
                break;
        }

    }
    //move position

    private static boolean movePosition(char[][] matrix, int row, int col) {
        rowPosition += row;
        colPosition += col;
        int money = 0;
        if (checkIndex(matrix)) {
            char current = matrix[rowPosition][colPosition];
            matrix[rowPosition][colPosition] = '-';
            if (Character.isDigit(current)) {
                money += Character.getNumericValue(current);
            } else if (current == 'P') {
                if (rowPosition == pillarOne[0] && colPosition == pillarOne[1]) {
                    rowPosition = pillarTwo[0];
                    colPosition = pillarTwo[1];
                } else {
                    rowPosition = pillarOne[0];
                    colPosition = pillarOne[1];
                }
                matrix[rowPosition][colPosition] = '-';
            }
            return false;
        }
        return true;
    }

    //check Index
    private static boolean checkIndex(char[][] matrix) {
        return rowPosition >= 0 && rowPosition < matrix.length
                && colPosition >= 0 && colPosition < matrix.length;
    }

    //print matrix

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}

