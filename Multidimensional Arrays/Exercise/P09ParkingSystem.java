package Exercise;

import java.util.Scanner;

public class P09ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        scanner.nextLine();
        boolean[][] matrix = new boolean[row][col];



    }

    private static boolean isFullRow(boolean[][] matrix, int desiredRow) {
        for (int i = 1; i < matrix.length ; i++) {
            if (!matrix[desiredRow][i]){
                return false;
            }
        }
        return true;
    }
}
