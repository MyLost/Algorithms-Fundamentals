
// Selection sort
public class SimpleSort {

    public static void main(String[] args) {
         int[] arr = {5, 4, 3, 2, 1,11,24,23,15,12,45,12,56,76,45,23,17,99,89};

         sort(arr);

         for (int i : arr) {
             System.out.print(i + " ");
         }

    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i + 1; j < arr.length ; j++) {
                //Only important thing is how we compare elements and we change order
                if(arr[j] > arr[index]) {
                    index = j;
                }
            }
            swap(arr, i , index);
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }
}
