import java.util.Arrays;
import java.util.Scanner;

public class P02PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = matrix(scanner);
        int number = Integer.parseInt(scanner.nextLine());

        boolean isFind = false;

        for (int row = 0; row < matrix.length; row++) {
            int[] rowMatrix = matrix[row];
            for (int col = 0; col < rowMatrix.length; col++) {
                if (number == rowMatrix[col]){
                    System.out.println(row + " " + col);
                    isFind = true;
                }
            }
        }
        if (!isFind){
            System.out.println("not found");
        }



    }

    private static int[][] matrix(Scanner scanner) {
        String[] input = scanner.nextLine().split("\\s+");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(" ")).
                    mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        return matrix;
    }
}
