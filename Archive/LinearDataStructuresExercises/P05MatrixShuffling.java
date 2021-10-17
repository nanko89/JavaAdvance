package LinearDataStructuresExercises;

import java.util.Scanner;

public class P05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine();
        int rows = Integer.parseInt(data.split(" ")[0]);
        int cols = Integer.parseInt(data.split(" ")[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(matrix, scanner);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(" ");
            if (tokens.length == 5) {
                String command = tokens[0];

                if (command.equals("swap")) {
                    int firstRow = Integer.parseInt(input.split(" ")[1]);
                    int firstCol = Integer.parseInt(input.split(" ")[2]);
                    int secondRow = Integer.parseInt(input.split(" ")[3]);
                    int secondCol = Integer.parseInt(input.split(" ")[4]);

                    if (isValidIndex(firstRow, firstCol, secondRow, secondCol, matrix)) {
                        String first = matrix[firstRow][firstCol];
                        String second = matrix[secondRow][secondCol];
                        matrix[firstRow][firstCol] = second;
                        matrix[secondRow][secondCol] = first;
                        printMatrix(matrix);
                    } else {
                        System.out.println("Invalid input!");
                    }
                }
            } else {
                System.out.println("Invalid input!");
            }
            input = scanner.nextLine();
        }
    }

        private static void printMatrix (String[][]matrix){
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
        }

        private static boolean isValidIndex ( int firstRow, int firstCol, int secondRow, int secondCol, String[][]
        matrix){
            return firstRow >= 0 && firstRow < matrix.length
                    && firstCol >= 0 && firstCol < matrix[firstRow].length
                    && secondRow >= 0 && secondRow < matrix.length
                    && secondCol >= 0 && secondCol < matrix[secondRow].length;
        }

        private static void fillMatrix (String[][]matrix, Scanner scanner){
            for (int row = 0; row < matrix.length; row++) {
                String[] line = scanner.nextLine().split(" ");
                matrix[row] = line;
            }
        }
    }
