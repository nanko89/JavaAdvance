
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int key = Integer.parseInt(scanner.nextLine());
        int index = getIndex(numbers,key, 0 , numbers.length - 1);

        System.out.println(index);
    }

    public static int getIndex(int[] arr, int key, int start, int end){

        while (start <= end){
            int mid = (end + start)/2;
            if (key < arr[mid]){
                end = mid -1;
            }else if (key > arr[mid]){
                start = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
