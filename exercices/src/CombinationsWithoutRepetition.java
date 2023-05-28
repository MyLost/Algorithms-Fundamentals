import java.util.Scanner;
public class CombinationsWithoutRepetition {

    public static int n;
    public static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = Integer.parseInt(scanner.nextLine());

        Integer k = Integer.parseInt(scanner.nextLine());

        arr = new int[k];

        combinations(0,1);
    }

    //Difference here is each recursion starts + 1
    private static void combinations(int index, int start) {
        if(index == arr.length) {
            printArr();
        } else {
            for (int i = start; i <= n; i++) {
                arr[index] = i;
                combinations(index+1, i+1);
            }
        }
    }

    public static void printArr() {

        for (int number : arr) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
