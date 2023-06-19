import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class ReverseArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        reverseArray(arr, 0, arr.length-1);

        Arrays.stream(arr).forEach(elem -> System.out.print(elem + " "));
    }

    public static void reverseArray(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        swap(arr, start, end);
        reverseArray(arr, start+1, end-1);
    }

    private static void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }
}
