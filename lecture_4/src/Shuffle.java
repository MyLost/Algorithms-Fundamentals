import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Shuffle {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] arr = {12, 15, 12, 24, 59};

        Arrays.sort(arr);

//      int [] random  = getAsRandom(arr);

        for (int rand: arr) {
            System.out.println(rand);
        }
    }

    private static void getAsRandom(int[] arr) {
        int [] result = new int[arr.length];

        ThreadLocalRandom threadLocalRandom = ThreadLocalRandom.current();

        for (int i = 0; i < arr.length; i++) {
//            result[i] = arr[threadLocalRandom.nextInt(arr.length - 1)];
            swap(arr, i , threadLocalRandom.nextInt(arr.length - 1));
        }

//        return result;
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }
}
