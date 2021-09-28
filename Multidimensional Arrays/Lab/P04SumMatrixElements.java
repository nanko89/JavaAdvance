import java.util.Arrays;
import java.util.Scanner;

public class P04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int[][] matrix = new int[row][col];
        int sum = 0;
        for (int i = 0; i < row; i++) {
            int[] array = Arrays.stream(scanner.nextLine().split(", ")).
                            mapToInt(Integer::parseInt).toArray();
            matrix[i] = array;
            for (int j = 0; j < array.length; j++) {
                int current = array[j];
                sum += current;
            }
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);

    }
}
