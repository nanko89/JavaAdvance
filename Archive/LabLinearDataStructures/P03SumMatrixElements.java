package LabLinearDataStructures;

import java.util.Arrays;
import java.util.Scanner;

public class P03SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] element = scanner.nextLine().split(", ");
        int row = Integer.parseInt(element[0]);
        int col = Integer.parseInt(element[1]);
        int sum = 0;
        int[][] matrix = new int[row][col];
        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            sum += Arrays.stream(matrix[i]).sum();
        }
        System.out.println(row);
        System.out.println(col);
        System.out.println(sum);
    }
}
