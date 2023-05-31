import java.util.Arrays;
import java.util.Collections;

public class CountSort {

    public static int[] counts;

    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};

        Integer max = Collections.max(Arrays.asList(1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10));

        counts = new int[max + 1];
        sort(numbers);

        for (int index=0; index < counts.length; index++) {
            if(counts[index] != 0) {
                for (int i = 0; i < counts[index]; i++) {
                    System.out.print(index + " ");
                }
            }
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            counts[arr[i]]++;
        }
    }
}
