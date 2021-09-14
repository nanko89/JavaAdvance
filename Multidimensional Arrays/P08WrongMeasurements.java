import java.util.Arrays;
import java.util.Scanner;

public class P08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[row][];

        for (int i = 0; i < row; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).
                            mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        String[] index = scanner.nextLine().split("\\s+");
        int rowIndex = Integer.parseInt(index[0]);
        int colIndex = Integer.parseInt(index[1]);


        int wrongDigit = matrix[rowIndex][colIndex];
        int col  = matrix[0].length;
        int[][] newMatrix = new int[row][col];
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == wrongDigit){
                    newMatrix[i][j] = replaceDigit(matrix,i,j,wrongDigit);
                }else {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
        }

        printMatrix(newMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int replaceDigit(int[][] matrix, int rowIndex, int colIndex, int wrongDigit) {
        int sum;

                int up = 0;
                if (rowIndex - 1 >= 0 ) {
                    up = matrix[rowIndex - 1][colIndex];
                    if (up == wrongDigit){
                        up = 0;
                    }
                }
                int down = 0;
                if (rowIndex + 1 < matrix.length){
                    down = matrix[rowIndex + 1][colIndex];
                    if (down == wrongDigit){
                        down = 0;
                    }
                }
                int left = 0;
                if (colIndex - 1 >= 0){
                    left = matrix[rowIndex][colIndex - 1];
                    if (left == wrongDigit){
                        left = 0;
                    }
                }
                int right = 0;
                if (colIndex + 1 < matrix[rowIndex].length){
                    right = matrix [rowIndex][colIndex + 1];
                    if (right == wrongDigit){
                        right = 0;
                    }
                }
                sum = left + right + up + down;

        return sum;
    }


}
