import java.util.Scanner;

public class P02 {
    public static int mouseRow = 0;
    public static int mouseCol = 0;
    public static int cheese = 0;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        char[][] matrix = fillMatrix(size, scanner);
        boolean isOutOfBound = false;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "up":
                    isOutOfBound = movePlayer(matrix, -1, 0);
                    break;
                case "down":
                    isOutOfBound = movePlayer(matrix, 1, 0);
                    break;
                case "left":
                    isOutOfBound = movePlayer(matrix, 0, -1);
                    break;
                case "right":
                    isOutOfBound = movePlayer(matrix, 0, 1);
                    break;
            }
            if (isOutOfBound) {
                break;
            }
            command = scanner.nextLine();

        }

        if (isOutOfBound) {
            System.out.println("Where is the mouse?");
        } else {
            matrix[mouseRow][mouseCol] = 'M';
        }
        if (cheese >= 5) {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        } else {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    private static boolean movePlayer(char[][] matrix, int row, int col) {

        if (checkIndex(matrix, mouseRow + row, mouseCol + col)) {
            mouseRow = mouseRow + row;
            mouseCol = mouseCol + col;
            char current = matrix[mouseRow][mouseCol];

            if (current == 'c'){
                cheese++;
                matrix[mouseRow][mouseCol] = '-';
            }else if (current == 'B'){
                matrix[mouseRow][mouseCol] = '-';
                movePlayer(matrix,row,col);
            }
            return false;
        } else {
            return true;
        }
    }

    private static boolean checkIndex(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix.length;
    }


    private static char[][] fillMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];

        for (int r = 0; r < size; r++) {
            String line = scanner.nextLine();
            for (int c = 0; c < size; c++) {
                matrix[r][c] = line.charAt(c);
                if (matrix[r][c] == 'M') {
                    mouseRow = r;
                    mouseCol = c;
                    matrix[r][c] = '-';
                }
            }
        }
        return matrix;
    }
}
