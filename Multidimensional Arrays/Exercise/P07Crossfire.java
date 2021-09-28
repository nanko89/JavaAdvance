package Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowDimension = scanner.nextInt();
        int colDimension = scanner.nextInt();
        scanner.nextLine();

        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(rowDimension, colDimension, matrix);

        String input = scanner.nextLine();

        while (!input.equals("Nuke it from orbit")) {
            int[] arr = Arrays.stream(input.split(" ")).
                    mapToInt(Integer::parseInt).toArray();
            int row = arr[0];
            int col = arr[1];
            int radius = arr[2];
            for (int i = row - radius; i <= row + radius; i++) {
                if (isInRange(i, col, matrix) && i != row){
                    matrix.get(i).remove(col);
                }
            }

            for (int i = col + radius; i >= col - radius; i--) {
                if (isInRange(row, i, matrix)){
                    matrix.get(row).remove(i);
                }
            }

            input = scanner.nextLine();
            matrix.removeIf(List::isEmpty);
            }


        printMatrix(matrix);

    }

    private static boolean isInRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();

    }

    private static boolean validRow(List<List<Integer>> matrix, int row, int index){
        return index >= 0 && index < matrix.get(row).size();
    }

    private static void printMatrix (List<List<Integer>> list){

        for (List<Integer> row : list) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();

        }
    }

    private static void fillMatrix(int rowDimension, int colDimension, List<List<Integer>> matrix) {

        int number = 1;
        for (int row = 0; row < rowDimension; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < colDimension; col++) {
                matrix.get(row).add(number++);

            }
        }
    }
}

