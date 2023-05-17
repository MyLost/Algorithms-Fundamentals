import java.util.*;

// Permutation with swap and standard way
public class Permutation {

    public static String[] elements;
    public static String[] permute;
    public static boolean[] used;
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         elements = scanner.nextLine().split("\\s+");
//         permute = new String[elements.length];
//         used = new boolean[elements.length];

         permute(0);
    }

    private static void permute(int index) {
         if(index == elements.length) {
             print(elements);
             return;
         }
        permute(index +1);

        for (int i = index+1; i < elements.length ; i++) {
            swap(elements, index, i);
            permute(index +1);
            swap(elements, index, i);

//            if(!used[i]) {
//                used[i] = true;
//                permute[index] = elements[i];
//                permute(index + 1);
//                used[i]=false;
//            }
        }
    }

    private static void swap(String[] arr, int first, int second) {
        String temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    private static void print() {
        System.out.println(String.join(" ", permute));
    }

    private static void print(String [] arr) {
        System.out.println(String.join(" ", arr));
    }
}