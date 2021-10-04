package Exam17Dec2019;

import java.util.Scanner;

public class P02PresentDelivery {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfPresents = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[n][n];
        int santaRow = 0;
        int santaCol = 0;
        int isHaveNiceKid = 0;
        int givePresentForNiceKid = 0;
        for (int row = 0; row < n; row++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int col = 0; col < n; col++) {
                matrix[row][col] = input[col].charAt(0);
                if (matrix[row][col] == 'S') {
                    santaRow = row;
                    santaCol = col;
                }
                if (matrix[row][col] == 'V') {
                    isHaveNiceKid++;
                }
            }
        }

        String command = scanner.nextLine();
        boolean lastCookie = false;
        while (!command.equals("Christmas morning") && countOfPresents > 0) {

            matrix[santaRow][santaCol] = '-';
            switch (command) {
                case "up":
                    santaRow--;
                    break;
                case "down":
                    santaRow++;
                    break;
                case "left":
                    santaCol--;
                    break;
                case "right":
                    santaCol++;
                    break;
            }

            if (!isValidMatrix(santaRow, santaCol, matrix)) {
                break;
            }
            if (matrix[santaRow][santaCol] == 'V') {
                    lastCookie = false;
                    countOfPresents--;
                    givePresentForNiceKid++;
                    isHaveNiceKid--;

            } else if (matrix[santaRow][santaCol] == 'C') {
                lastCookie = true;
                if (isValidMatrix(santaRow + 1, santaCol, matrix)) {
                    if (isHaveChild(santaRow + 1, santaCol, matrix)){
                        if (matrix[santaRow + 1][santaCol] == 'V'){
                            isHaveNiceKid--;
                            givePresentForNiceKid++;
                        }
                            countOfPresents --;
                            matrix[santaRow+ 1][santaCol] = '-';
                    }
                }
                if (isValidMatrix(santaRow - 1, santaCol, matrix) && countOfPresents > 0) {
                    if (isHaveChild(santaRow - 1, santaCol, matrix)){
                        if (matrix[santaRow - 1][santaCol] == 'V'){
                            isHaveNiceKid--;
                            givePresentForNiceKid++;
                        }
                        countOfPresents --;
                        matrix[santaRow - 1][santaCol] = '-';
                    }
                }
                if (isValidMatrix(santaRow, santaCol + 1, matrix) && countOfPresents > 0) {
                    if (isHaveChild(santaRow, santaCol +1 , matrix)){
                        if (matrix[santaRow][santaCol + 1] == 'V'){
                            isHaveNiceKid--;
                            givePresentForNiceKid++;
                        }
                        countOfPresents --;
                        matrix[santaRow][santaCol+1] = '-';
                    }
                }
                if (isValidMatrix(santaRow, santaCol - 1, matrix)) {
                    if (isHaveChild(santaRow, santaCol - 1, matrix) && countOfPresents > 0){
                        if (matrix[santaRow ][santaCol - 1] == 'V'){
                            isHaveNiceKid--;
                            givePresentForNiceKid++;
                        }
                        countOfPresents --;
                        matrix[santaRow][santaCol - 1] = '-';
                    }
                }

            }else {
                lastCookie = false;
            }
            matrix[santaRow][santaCol] = 'S';

            if (countOfPresents == 0){
                break;
            }
            command = scanner.nextLine();

        }
        if (countOfPresents  == 0 && !lastCookie){
            System.out.println("Santa ran out of presents!");
        }
        printMatrix(matrix);
        if (isHaveNiceKid == 0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.",givePresentForNiceKid);
        }else {
            System.out.printf("No presents for %d nice kid/s.", isHaveNiceKid);
        }

    }

    private static void printMatrix(char[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isHaveChild(int row, int col, char[][] matrix) {
        return matrix[row][col] == 'X'
                || matrix[row][col] == 'V';
    }

    private static boolean isValidMatrix(int santaRow, int santaCol, char[][] matrix) {
        return santaRow >= 0 && santaRow < matrix.length && santaCol >= 0 && santaCol < matrix[santaRow].length;
    }

}
