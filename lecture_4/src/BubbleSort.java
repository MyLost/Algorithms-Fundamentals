public class BubbleSort {

    public static void main(String[] args) {

        int[] numbers = {1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10};

        sort(numbers);

        for (int i : numbers) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    swap(arr, i ,j );
                }
            }
        }
    }

    private static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;

    }
}
