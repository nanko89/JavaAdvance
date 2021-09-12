import java.util.Arrays;
import java.util.Scanner;

public class P01CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = matrix(scanner);
        int[][] secondMatrix = matrix(scanner);

        boolean areEqual = areEqual(firstMatrix, secondMatrix);

        System.out.println(areEqual ? "equal" : "not equal");
    }

    private static boolean areEqual(int[][] firstMatrix, int[][] secondMatrix) {
        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] first = firstMatrix[row];
            int[] second = secondMatrix[row];
            if (first.length != second.length) {
                return false;
            }
            for (int col = 0; col < first.length; col++) {
                if (first[col] != second[col]) {
                    return false;
                }
            }
        }
        return true;
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
