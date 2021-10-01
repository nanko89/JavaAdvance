package Exam26Oct2019;

import java.util.Scanner;

public class P02BookWorm {
    public static int[] playerPosition = new int[2];
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder word = new StringBuilder(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        fillMatrix(matrix,scanner);

        String input = scanner.nextLine();
        while (!input.equals("end")){
        boolean isOutOfGrid = false;
            switch (input){

                case "up":
                    if (playerPosition[0] - 1 >= 0){
                        matrix[playerPosition[0]][playerPosition[1]] = '-';
                        playerPosition[0] -= 1;

                    }else {
                        isOutOfGrid = true;
                    }
                    break;
                case "down":
                    if (playerPosition[0] + 1 < matrix.length) {
                        matrix[playerPosition[0]][playerPosition[1]] = '-';
                        playerPosition[0] += 1;

                    }else {
                        isOutOfGrid = true;
                    }
                    break;
                case "right":
                    if ( playerPosition[1] + 1 < matrix.length) {
                        matrix[playerPosition[0]][playerPosition[1]] = '-';
                        playerPosition[1] += 1;

                    }else {
                        isOutOfGrid = true;
                    }
                    break;
                case "left":
                    if (playerPosition[1] - 1 >= 0) {
                        matrix[playerPosition[0]][playerPosition[1]] = '-';
                        playerPosition[1] -= 1;

                    }else {
                        isOutOfGrid = true;
                    }
                    break;
            }
                if (isOutOfGrid){
                    if (word.length() > 0){
                        word.deleteCharAt(word.length() - 1);
                    }
                }else {
                   char current  = matrix[playerPosition[0]][playerPosition[1]];
                    matrix[playerPosition[0]][playerPosition[1]] = 'P';
                    if (current != '-') {
                        word.append(current);
                    }
                }

            input = scanner.nextLine();

        }


        System.out.println(word);
        printMatrix(matrix);

    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix.length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(char[][] matrix, Scanner scanner) {
        for (int row = 0; row < matrix.length; row++) {
            String line = scanner.nextLine();
            for (int col = 0; col < line.length(); col++) {
                matrix[row][col] = line.charAt(col);
                if (matrix[row][col] == 'P'){
                    playerPosition[0] = row;
                    playerPosition[1] = col;

                }
            }
        }

    }
}
