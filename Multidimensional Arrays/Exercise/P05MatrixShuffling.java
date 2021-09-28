package Exercise;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int rows = Integer.parseInt(input.split(" ")[0]);
        int cols = Integer.parseInt(input.split(" ")[1]);
        String[][] matrix = new String[rows][cols];

        readMatrix(matrix,rows,scanner);

        String command = scanner.nextLine();

        while (!command.equals("END")){

            String[] currentCommand = command.split("\\s+");
            if (currentCommand.length == 5 && currentCommand[0].equals("swap")){
                int firstRow = Integer.parseInt(currentCommand[1]);
                int firstCol = Integer.parseInt(currentCommand[2]);

                int secondRow = Integer.parseInt(currentCommand[3]);
                int secondCol = Integer.parseInt(currentCommand[4]);
                if (isValidCoordinate(firstCol,cols) && isValidCoordinate(secondCol,cols)
                && isValidCoordinate(firstRow,rows) && isValidCoordinate(secondRow,rows)) {

                    String firstElement = matrix[firstRow][firstCol];
                    String secondElement = matrix[secondRow][secondCol];

                    matrix[secondRow][secondCol] = firstElement;
                    matrix[firstRow][firstCol] = secondElement;

                    printMatrix(matrix);
                }else {
                    System.out.println("Invalid input!");
                }

            }else {
                System.out.println("Invalid input!");
            }

            command = scanner.nextLine();

        }

    }

    private static boolean isValidCoordinate(int index, int length) {

        return index >= 0 && index < length ;
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void readMatrix(String[][] matrix, int rows, Scanner scanner) {
        for (int row = 0; row < rows ; row++) {
            String[] arr = scanner.nextLine().split(" ");
            matrix[row] = arr;
        }
    }
}
