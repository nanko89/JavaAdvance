import java.util.Arrays;
import java.util.Scanner;

public class P05MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] info = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = info[0];
        int cols = info[1];

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            int[] currentRow = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).toArray();
            matrix[i] = currentRow;
        }

        int maxSum = Integer.MIN_VALUE;
        int[] first = new int[2];
        int[] second = new int[2];
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1]
                        + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > maxSum){
                    maxSum = sum;
                    first[0] = matrix[row][col];
                    first[1] = matrix[row][col + 1];
                    second[0] = matrix[row + 1][col];
                    second[1] = matrix[row + 1][col + 1];

                }
            }
        }
        System.out.println(Arrays.toString(first).replaceAll("[\\[\\],]", ""));
        System.out.println(Arrays.toString(second).replaceAll("[\\[\\],]", ""));
        System.out.println(maxSum);


        System.out.println();
        }
    }

