import java.util.Arrays;
import java.util.Scanner;
public class RecursiveArraySum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        System.out.println(sum(arr, arr.length -1));
    }

    private static int sum(int[] arr, int length) {
        if(length < 0) {
            return 0;
        }

        return arr[length] + sum(arr, --length);
    }
}